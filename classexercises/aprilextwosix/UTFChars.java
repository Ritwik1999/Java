package classexercises.aprilextwosix;

import java.util.*;
import java.io.*;

public class UTFChars {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int choice;
        int charCode = 1013;

        File obj = new File("sample.txt");
        FileOutputStream fout = new FileOutputStream(obj);
        OutputStreamWriter iwrite = new OutputStreamWriter(fout, "UTF-16");
        FileInputStream fin = new FileInputStream(obj);
        InputStreamReader iread = new InputStreamReader(fin, "UTF-16");

        do {
            int option;
            System.out.print("Enter 1 to write a UTF-16 character, or 2 to read all characters: ");
            option = Integer.parseInt(input.nextLine());

            switch (option) {
            case 1:
                iwrite.write(charCode);
                charCode++;
                System.out.println("Written");
                break;

            case 2:
                int temp = charCode;               
                while (temp >= 1013) {
                    int data = iread.read();
                    System.out.println("Code: " + data + "\tCharacter: " + (char) data);
                    temp--;
                }
                break;

            default:
                System.out.println("Bad input");
                break;
            }
            System.out.println("Enter 1 if you want to continue: ");
            choice = Integer.parseInt(input.nextLine());
        } while (choice == 1);

        input.close();
        iwrite.close();
        iread.close();
    }
}
