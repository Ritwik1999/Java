/*
    FileWriter class. similar methods as in FileReader
*/

package files;

import java.io.*;

public class FileReaderWrite {
    public static void main(String[] args) throws Throwable {
        File obj = new File("files/test1.txt");
        FileWriter fiw = new FileWriter(obj, true);   // true tells fiw to append whatever is being written

        // char c[] = {'r', 'i', 't', 'w', 'i', 'k'};
        // fiw.write(c);
        // fiw.write(c, 1, 4);

        String name = "RITWIK NEEMA";
        fiw.write(name);
        
        fiw.close();
        System.out.println("Done");
    }
}
