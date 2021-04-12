package threads;

public class ThreadIntro2 {
    public static void main(String[] args) {
        // Instead of creating a separate class that implments Runnable interface, we
        // use anonymous classes
        Thread thr1 = new Thread(new Runnable() {
            public void run() {
                int p = Thread.currentThread().getPriority();
                System.out.println("I am from the thread 1; my priority value is: " + p);
            }
        });
        thr1.start();
        thr1.setPriority(10);

        Thread thr2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int p = Thread.currentThread().getPriority();
                System.out.println("I am from thread 2; my priority value is: " + p);
            }
        });
        thr2.start();
        thr2.setPriority(1);

        // Thread.currentThread returns a reference to the currently executing thread
        int p = Thread.currentThread().getPriority();
        System.out.println("I am from the main thread; my priority value is: " + p);
        System.out.println("Main thread name is: " + Thread.currentThread().getName());
    }
}
