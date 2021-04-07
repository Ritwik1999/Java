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

public class CharacterRead {
    public static void main(String[] args) throws Throwable {
        // Use FileReader for reading text files
        File obj = new File("files/test.txt");
        FileReader fin = new FileReader(obj);
        int data = fin.read();
        System.out.println(data);

        fin.close();
    }
}
