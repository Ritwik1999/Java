/*
    Streams are sequence of bytes, we read them from various sources, and can also write them to various sources

    How to read data? (FileInputStream)
    > We can read data as 8 bit bytes
    e.g., 00000011 00001111

    > We can read data as characters (sequence of bytes encoded as a symbol) (FileReader)
    i.e., as ANSI (ASCII + 128 more entities; 8 bit encoding; used by Windows), or ASCII(7 bit encoding), or Unicode(UTF-8, 8 bits or UTF-16, 16 bits) characters
    e.g., h is encoded in ASCII as 104

    > As primitive data types
    int, boolean, char, String, float, double

    > We can read objects
    Deserialization of objects
*/

/*
    FileInputStream (extends InputStream) is used to read data in bytes from the input file.
    Constructors used for FileInputStream class
        > FileInputStream(File file) - creates a FileInputStream by opening a connection to an actual file,
        the file named by the File object, file, in the file system.

        > FileInputStream(String name) - creates a FileInputStream by opening a connection to an actual file,
        the file named by the pathname name in the file system.
*/

/*
    FileReader (extends InputStream) is a convenience class for reading character files.
    FileReader is meant for reading streams of characters
    It assumes the default encoding to be appropriate (Windows follows ANSI)
    For reading streams of raw bytes, consider using a FileInputStream

    Constructors
    > FileReader (File file)
    > FileReader (String fileName)
*/

package files;

import java.io.File;
import java.io.FileInputStream;

public class FileInputStreamRead {
    public static void main(String[] args) throws Throwable {
        try {
            File obj = new File("/home/ritwik/Desktop/Sem 6/Java/files/test.txt");
            FileInputStream fin = new FileInputStream(obj);

            // read() - Reads a byte of data from this input Streams int data = fin.read();
            // outputs 104, i.e., h of hello in test.txt
            // int data;
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

            fin.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}