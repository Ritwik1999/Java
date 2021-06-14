package threads;

public class ThreadIntro4 {
    public static void main(String[] args) {
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

        try {
            // Try commenting lines 21 and/or 23 to see what does Thread.join() do
            thr1.start();
            thr1.join(); // throws InterruptedException
            thr2.start();
            thr2.join();

            System.out.println("Thanks for reading the message");
        } catch (Exception e) {
            System.out.println("Exception Occurred");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}