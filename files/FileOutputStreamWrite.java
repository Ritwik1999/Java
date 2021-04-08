package files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamWrite {
    public static void main(String[] args) throws Throwable {
        File obj = new File("files/testOutput.txt");
        FileOutputStream fout = new FileOutputStream(obj);
        fout.write(104);
        fout.close();

        FileInputStream fin = new FileInputStream(obj);
        int data = fin.read();
        System.out.println((char)data);
        fin.close();
    }
}
