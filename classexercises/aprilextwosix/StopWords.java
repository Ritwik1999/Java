package classexercises.aprilextwosix;

import java.util.*;
import java.io.*;

public class StopWords {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Runnable r1 = () -> {
            try {
                int countA = 0;
                int countAnd = 0;
                int countThe = 0;
                File obj = new File("sample1.txt");
                Scanner input = new Scanner(obj);
                while (input.hasNext()) {
                    String word = input.next();
                    if (word.equals("a")) {
                        countA++;
                    } else if (word.equals("and")) {
                        countAnd++;
                    } else if (word.equals("the")) {
                        countThe++;
                    }
                }

                System.out.println("'a' occurs: " + countA + " times");
                System.out.println("'and' occurs: " + countAnd + " times");
                System.out.println("'the' occurs: " + countThe + " times");

                input.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Runnable r2 = () -> {
            try {
                int countS = 0;
                File obj = new File("sample2.txt");
                Scanner input = new Scanner(obj);
                while (input.hasNext()) {
                    String word = input.next();
                    if (word.charAt(0) == 'S') {
                        countS++;
                    }
                }

                System.out.println("'S' occurs: " + countS + " times");

                input.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Runnable r3 = () -> {
            System.out.println("Thanks for using our software");
        };

        Thread thr1 = new Thread(r1);
        Thread thr2 = new Thread(r2);
        Thread thr3 = new Thread(r3);

        thr1.start();
        thr1.setPriority(2);
        thr2.start();
        thr2.setPriority(1);
        thr1.join();
        thr2.join();
        thr3.start();
        thr3.setPriority(1);
    }
}