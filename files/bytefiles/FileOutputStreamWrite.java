package files.bytefiles;

import java.io.*;

public class FileOutputStreamWrite {
    public static void main(String[] args) {
        File obj = new File("files/bytefiles/fistestoutput.txt");
        try {
            FileOutputStream fout = new FileOutputStream(obj); // throws FileNotFoundException
            fout.write(104); // throws IOException, or writes h
            fout.close(); // throws IOException

            FileOutputStream fout2 = new FileOutputStream(obj, true); // Appends data to the file
            fout2.write(120); // Writes x
            byte b[] = new byte[] { 10, 97, 98, 99, 10 };
            fout2.write(b);
            fout2.write(b, 1, 3);
            fout2.close();

            FileInputStream fin = new FileInputStream(obj);
            int data = fin.read();
            System.out.println((char) data);
            fin.close();
        } catch (Exception e) {
            System.out.println("Exception occured: ");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}
