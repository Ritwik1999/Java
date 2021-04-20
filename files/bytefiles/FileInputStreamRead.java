/*
    FileInputStream (extends InputStream) is used to read data in bytes from the input file.
    Constructors used for FileInputStream class
        > FileInputStream(File file) - creates a FileInputStream by opening a connection to an actual file,
        the file named by the File object, file, in the file system.

        > FileInputStream(String name) - creates a FileInputStream by opening a connection to an actual file,
        the file named by the pathname name in the file system.
*/

package files.bytefiles;

import java.io.*;

public class FileInputStreamRead {
    public static void main(String[] args) {
        try {
            File obj = new File("/home/ritwik/Desktop/Sem 6/Java/files/test.txt");
            FileInputStream fin = new FileInputStream(obj);

            // read() - Reads a byte of data from this input Streams int data = fin.read();
            // outputs 104, i.e., h of hello in test.txt
            int data = fin.read();
            System.out.println(data);
            // while ((data = fin.read()) != -1) {
            // System.out.println((char)data); }

            byte b[] = new byte[5];
            // read(byte b[], int offset, int length) - reads upto length bytes of data from
            // this input stream into an array of bytes, starting from index offset
            fin.read(b, 1, 2);
            for (byte k : b) {
                System.out.println(k);
            }

            // available() - returns an estimate of the number of remaining bytes that can
            // be read from this input stream
            System.out.println(fin.available());

            fin.close();
        } catch (Exception e) {
            System.out.println("Exception occurred");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}