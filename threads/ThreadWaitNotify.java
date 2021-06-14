package threads;

public class ThreadWaitNotify {
    public static void main(String[] args) {
        Account1 ac = new Account1(2000);

        Thread thr1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ac.withdraw(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thr2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ac.deposit(40000);
            }
        });

        try {
            thr1.start();
            thr2.start();
            thr1.join();
            thr2.join();
            
            System.out.println("Final Balance is: " + ac.balance);
        } catch (Exception e) {
            System.out.println("Exception Occurred");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}

class Account1 {
    int balance;

    Account1(int balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(int withdrawAmount) throws InterruptedException {
        System.out.println("Thread " + Thread.currentThread().getId() + " is trying to withdraw");
        while (withdrawAmount > balance) {
            System.out.println("Thread " + Thread.currentThread().getId() + " is waiting due to insufficient balance");
            wait(); // throws InterruptedException
        }

        this.balance -= withdrawAmount;
        System.out.println("Thread " + Thread.currentThread().getId() + " withdrawal successful");
    }

    public synchronized void deposit(int depositAmount) {
        System.out.println("Thread " + Thread.currentThread().getId() + " is trying to deposit");
        this.balance += depositAmount;
        System.out.println("Thread " + Thread.currentThread().getId() + " deposit successful");
        notify();
    }
}