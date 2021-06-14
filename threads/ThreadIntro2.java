package threads;

public class ThreadIntro2 {
    public static void main(String[] args) {
        Thread thr1 = new Thread(new Test1());
        Thread thr2 = new Thread(new Test2());

        thr2.setPriority(1);
        thr1.setPriority(10);

        thr1.start();
        thr2.start();
    }
}

class Test1 implements Runnable {
    @Override
    public void run() {
        int p = Thread.currentThread().getPriority();
        System.out.println("I am from the thread 1; my priority value is: " + p);
    }
}

class Test2 implements Runnable {
    @Override
    public void run() {
        int p = Thread.currentThread().getPriority();
        System.out.println("I am from the thread 2; my priority value is: " + p);
    }
}
