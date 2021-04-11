package threads;

public class ThreadIntro2 {
    public static void main(String[] args) {

        // Instead of creating a separate class that implments Runnable interface, we use anonymous classes
        Thread thr1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("I am from the thread 1");
            }
        });
        thr1.start();

        Thread thr2 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("I am from thread 2");
            }
        });
        thr2.start();

        System.out.println("I am from the main thread");
    }
}
