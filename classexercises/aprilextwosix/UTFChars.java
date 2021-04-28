package classexercises.aprilextwosix;

import java.util.*;
import java.io.*;

public class UTFChars {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int choice;

        File obj = new File("sample.txt");
        FileOutputStream fout = new FileOutputStream(obj, true);
        FileInputStream fin = new FileInputStream(obj);

        System.out.println();
        do {
            int option;
            int dataToBeWritten;
            System.out.print("Enter 1 to write a UTF-16 character, or 2 to read all characters: ");
            option = Integer.parseInt(input.nextLine());

            switch (option) {
            case 1:
                OutputStreamWriter iwrite = new OutputStreamWriter(fout, "UTF-16");
                System.out.print("Enter data to be written: ");
                dataToBeWritten = Integer.parseInt(input.nextLine());
                iwrite.write(dataToBeWritten);
                break;

            case 2:
                InputStreamReader iread = new InputStreamReader(fin, "UTF-16");
                int data;
                while ((data = iread.read()) != -1) {
                    System.out.println("Code: " + data + "\tCharacter: " + (char) data);
                }
                break;

            default:
                System.out.println("Bad input");
                break;
            }
            System.out.println("Enter 1 if you want to continue: ");
            choice = Integer.parseInt(input.nextLine());
        } while (choice == 1);

        fout.close();
        fin.close();
        input.close();
    }
}
