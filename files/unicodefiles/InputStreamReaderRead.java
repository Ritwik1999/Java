/*
    > An InputStreamReader should be constructed on FileInputStream
    > The InputStreamReader will get the named charset as another argument
    > The text file should be encoded using the unicode format
*/

package files.unicodefiles;

import java.io.*;

public class InputStreamReaderRead {
    public static void main(String[] args) {
        try {
            File obj = new File("files/unicodefiles/epsilon.txt");
            FileInputStream fin = new FileInputStream(obj); // throws FileNotFoundException
            InputStreamReader iread = new InputStreamReader(fin, "UTF-16"); // throws UnsupportedEncodingException
            int data = iread.read(); // throws IOException
            System.out.println(data);
            System.out.println((char) data);
            iread.close(); // throws IOException
        } catch (Exception e) {
            System.out.println("Exception occurred");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}