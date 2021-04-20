package threads;

public class ThreadWaitNotifyAll {
    public static void main(String[] args) throws InterruptedException {
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
                ac.deposit(40000);
            }
        });

        thr1.start();
        thr2.start();
        thr3.start();
        thr1.join();
        thr2.join();
        thr3.join();

        System.out.println(ac.balance);
    }
}

class Account2 {
    int balance;

    Account2(int balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(int withdrawAmount) throws InterruptedException {
        System.out.println("This is withdrawal " + Thread.currentThread().getId());
        while (withdrawAmount > balance) {
            System.out.println("Thread is waiting " + Thread.currentThread().getId());
            // wait releases the lock
            wait();
        }
        System.out.println("Withdrawal in progress " + Thread.currentThread().getId());
        this.balance -= withdrawAmount;
    }

    public synchronized void deposit(int depositAmount) {
        System.out.println("This is deposit " + Thread.currentThread().getId());
        this.balance += depositAmount;
        System.out.println("Notifying " + Thread.currentThread().getId());
        notifyAll();
    }
}