package threads;

public class ThreadIssues {
    public static void main(String[] args) throws InterruptedException {
        Account ac = new Account(15000);

        Thread thr1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ac.withdraw(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thr2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ac.deposit(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thr1.start();
        thr2.start();
        thr1.join();
        thr2.join();

        // Final balance should be 5000 (ideally)
        System.out.println("Final Balance: " + ac.balance);
    }
}

class Account {
    public int balance;

    Account(int deposit) {
        this.balance = deposit;
    }

    public void withdraw(int withdrawAmount) throws InterruptedException {
        synchronized (this) {
            System.out.println("Withdrawal in progress");
            // This causes the current thread to sleep (pause) for 5 seconds
            Thread.sleep(5000); // throws InterruptedException
            this.balance -= withdrawAmount;
        }

        System.out.println("I am not synchronized");
    }

    public synchronized void deposit(int depositAmount) throws InterruptedException {
        System.out.println("Deposit in progress");
        Thread.sleep(5000);
        this.balance += depositAmount;
    }
}
