package threads;

public class ThreadWaitNotifyAll {
    public static void main(String[] args) {
        Account2 ac = new Account2(2000);

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
                try {
                    ac.withdraw(40000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thr3 = new Thread(new Runnable() {

            @Override
            public void run() {
                ac.deposit(80000);
            }
        });

        try {
            thr1.start();
            thr2.start();
            thr3.start();
            thr1.join();
            thr2.join();
            thr3.join();

            System.out.println("Final Balance is: " + ac.balance);
        } catch (Exception e) {
            System.out.println("Exception Occurred");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}

class Account2 {
    int balance;

    Account2(int balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(int withdrawAmount) throws InterruptedException {
        System.out.println("Thread " + Thread.currentThread().getId() + " is trying to withdraw");
        while (withdrawAmount > balance) {
            System.out.println("Thread " + Thread.currentThread().getId() + " is waiting due to insufficient balance");
            // wait releases the lock
            wait();
        }

        this.balance -= withdrawAmount;
        System.out.println("Thread " + Thread.currentThread().getId() + " withdrawal successful");
    }

    public synchronized void deposit(int depositAmount) {
        System.out.println("Thread " + Thread.currentThread().getId() + " is trying to deposit");
        this.balance += depositAmount;
        System.out.println("Thread " + Thread.currentThread().getId() + " deposit successful");
        notifyAll();
    }
}