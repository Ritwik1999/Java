package threads;

public class ThreadStaticSync {
    public static void main(String[] args) {
        Test t = new Test();
        Thread thr1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Test.display();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thr2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Test.display();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thr3 = new Thread(new Runnable() {
            @Override
            public void run() {
                t.display1();
            }
        });

        thr1.start();
        thr2.start();
        thr3.start();
    }
}

class Test {
    public static synchronized void display() throws InterruptedException {
        System.out.println("I am from synchronized static");
        Thread.sleep(5000);
    }

    public synchronized void display1() {
        System.out.println("I am not static, but synchronized");
    }
}
