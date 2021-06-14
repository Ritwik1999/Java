package files.scannerio;

import java.io.*;
import java.util.*;

public class ScannerIO {
    public static void main(String[] args) {
        try {
            // read data from a file using Scanner
            File obj = new File("files/scannerio/scannerfile.txt");
            Scanner input = new Scanner(obj); // throws FileNotFoundException
            while (input.hasNextLine()) {
                System.out.println(input.nextLine()); // Prints line by line
            }
            input.close();

            input = new Scanner(obj);
            while (input.hasNext()) {
                System.out.println(input.next()); // Prints word by word
            }
            input.close();
        } catch (Exception e) {
            System.out.println("Exception Occurred");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}
