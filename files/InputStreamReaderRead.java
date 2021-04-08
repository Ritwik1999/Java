/*
    > An InputStreamReader should be constructed on FileInputStream
    > The InputStreamReader will get the named charset as another argument
    > The text file should be encoded using the unicode format
*/

package files;

import java.io.*;

public class InputStreamReaderRead {
    public static void main(String[] args) throws Throwable {
        File obj = new File("files/epsilon.txt");
        FileInputStream fin = new FileInputStream(obj);
        InputStreamReader iread = new InputStreamReader(fin, "UTF-16");
        int data = iread.read();
        System.out.println(data);
        System.out.println((char)data);
        iread.close();
    }
}
