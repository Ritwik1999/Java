package threads;

import java.io.*;

public class ThreadIntro {
    public static void main(String[] args) {
        processfile1 file1 = new processfile1("ritwik thread 1");
        processfile2 file2 = new processfile2("ritwik thread 2");

        // NOTE: From the line below, three threads run in parallel, main, file1 thread
        // and file2 thread. Hence, sysout outputs will be interleaved
        file1.start();
        file2.start();

        System.out.println(file1.getName());
        System.out.println(file2.getName());
    }
}

class processfile1 extends Thread {
    processfile1(String s) {
        super(s);
    }

    @Override
    public void run() {
        File obj = new File("threads/file1.txt");
        FileOutputStream fout;
        try {
            fout = new FileOutputStream(obj);
            for (int i = 1; i <= 100; i++) {
                System.out.println("File 1 write");
                fout.write(i);
            }
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Written to file 1");
    }
}

class processfile2 extends Thread {
    processfile2(String s) {
        super(s);
    }

    @Override
    public void run() {
        File obj = new File("threads/file2.txt");
        FileOutputStream fout;
        try {
            fout = new FileOutputStream(obj);
            for (int i = 101; i <= 200; i++) {
                System.out.println("File 2 write");
                fout.write(i);
            }
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Written to file 2");
    }
}