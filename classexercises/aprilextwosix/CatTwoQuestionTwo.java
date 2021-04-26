package classexercises.aprilextwosix;

import java.io.*;

public class CatTwoQuestionTwo {
    public static void main(String[] args) throws Exception {
        Runnable r1 = () -> {
            try {
                FileOutputStream fout = new FileOutputStream(new File("file1.txt"));
                DataOutputStream dout = new DataOutputStream(fout);

                int i = 2;
                while (true) {
                    if (isPrime(i)) {
                        dout.writeInt(i);
                    }
                    i++;
                    if (i > 100) {
                        break;
                    }
                }

                Thread.sleep(2000);
                dout.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Runnable r2 = () -> {
            try {
                FileOutputStream fout = new FileOutputStream(new File("file2.txt"));
                DataOutputStream dout = new DataOutputStream(fout);

                int i = 101;
                while (true) {
                    if (isPrime(i)) {
                        dout.writeInt(i);
                    }
                    i++;
                    if (i > 200) {
                        break;
                    }
                }

                Thread.sleep(2000);
                dout.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Thread thr1 = new Thread(r1);
        Thread thr2 = new Thread(r2);
        thr1.start();
        thr2.start();
        thr1.join();
        thr2.join();

        Runnable r3 = () -> {
            try {
                FileInputStream fin = new FileInputStream(new File("file1.txt"));
                DataInputStream din = new DataInputStream(fin);

                int data;
                while (din.available() > 0) {
                    data = din.readInt();
                    System.out.println(data);
                }

                din.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Runnable r4 = () -> {
            try {
                FileInputStream fin = new FileInputStream(new File("file2.txt"));
                DataInputStream din = new DataInputStream(fin);

                int data;
                while (din.available() > 0) {
                    data = din.readInt();
                    System.out.println(data);
                }

                din.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Thread thr3 = new Thread(r3);
        Thread thr4 = new Thread(r4);
        thr3.start();
        thr4.start();
    }

    public static boolean isPrime(int n) {
        boolean ans = true;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                ans = false;
                break;
            }
        }

        return ans;
    }
}