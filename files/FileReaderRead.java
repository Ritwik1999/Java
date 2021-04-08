/*
    FileReader class methods

    > public int read() throws IOException - reads a single character
    > public int read(char buf[]) throws IOException - reads characters into an array
    > public int read(char cbuf[], int offset, int length) throws IOException - reads characters into a portion of an array
    > public void close() throws IOException - closes the stream and releases any system resource associated with it
*/

package files;

import java.io.File;
import java.io.FileReader;

public class FileReaderRead {
    public static void main(String[] args) throws Throwable {
        try {
            // Use FileReader for reading text files
            File obj = new File("files/test.txt");
            FileReader fir = new FileReader(obj);
            int data = fir.read(); // Reads the h in hello
            System.out.println((char) data);

            // Reading an array of characters
            char c[] = new char[4];
            fir.read(c); // Reads the ello in hello

            for (char k : c) {
                System.out.println(k);
            }
            fir.close();

            fir = new FileReader(obj);
            char c1[] = new char[4];
            fir.read(c1, 1, 2); // Reads h, e in the array c1 from index 1, for length 2

            for (char k : c1) {
                System.out.println(k);
            }
            fir.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}