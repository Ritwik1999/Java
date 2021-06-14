package files.scannerio;

import java.util.*;
import java.io.*;

public class StopWords {
    public static void main(String[] args) {
        try {
            // Determine count of stop words in the file. Stop words are a, and, the.
            // If no such words, display message
            int count = 0;
            File obj = new File("files/scannerio/stopwords.txt");
            Scanner input = new Scanner(obj);
            System.out.println("Default delimiter while reading strings using Scanner is: " + input.delimiter());
            input.useDelimiter(",");
            System.out.println("Changing the delimiter to be a " + input.delimiter());
            while (input.hasNext()) {
                String word = input.next(); // We also have input.nextInt(), input.nextDouble(), etc
                if (word.equals("a") || word.equals("and") || word.equals("the")) {
                    count += 1;
                }
            }

            if (count == 0) {
                System.out.println("No stop words");
            } else {
                System.out.println("There are " + count + " stop words in the file.");
            }

            input.close();
        } catch (Exception e) {
            System.out.println("Exception Occurred");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}
