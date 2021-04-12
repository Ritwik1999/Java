package threads;

public class ThreadIntro3 {
    public static void main(String[] args) throws InterruptedException {
        // Instead of creating a separate class that implments Runnable interface, we
        // use anonymous classes
        Thread thr1 = new Thread(new Runnable() {
            public void run() {
                System.out.print("Hello, ");
            }
        });

        Thread thr2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" World");
            }
        });

        // Try commenting lines 22 and/or 24 to see what does Thread.join() do
        thr1.start();
        thr1.join();
        thr2.start();
        thr2.join();

        System.out.println("Thanks for using our software");
        
    }
}
