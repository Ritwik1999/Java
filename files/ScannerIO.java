package files;

import java.io.*;
import java.util.Scanner;

public class ScannerIO {
    public static void main(String[] args) throws Throwable {
        File obj = new File("files/scannerfile.txt");
        Scanner input = new Scanner(obj);
        String line;

        // Read line by line
        while(input.hasNextLine()) {
            line = input.nextLine();
            System.out.println(line);
        }

        input.close();

        input = new Scanner(obj);
        String word;

        while(input.hasNext()) {
            word = input.next();
            System.out.println(word);
        }

        input.close();
    }
}
