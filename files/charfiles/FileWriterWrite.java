/*
    FileWriter class. similar methods as in FileReader
*/

package files.charfiles;

import java.io.*;

public class FileWriterWrite {
    public static void main(String[] args) {
        char c[] = { 'r', 'i', 't', 'w', 'i', 'k' };
        File obj = new File("files/charfiles/charfilestestoutput.txt");
        try {
            FileWriter fiw = new FileWriter(obj, true); // true tells fiw to append whatever is being written

            fiw.write(c);
            fiw.write(10);
            fiw.write(c, 1, 4);
            fiw.write(10);

            String name = "RITWIK NEEMA";
            fiw.write(name);

            fiw.close();
            System.out.println("Done");
        } catch (Exception e) {
            System.out.println("Exception occurred");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}
