package files.unicodefiles;

import java.io.*;

public class OutputStreamWriterWrite {
    public static void main(String[] args) throws IOException {
        File obj = new File("files/unicodefiles/unicodefilesoutput.txt");
        FileOutputStream fout = new FileOutputStream(obj);
        OutputStreamWriter iwrite = new OutputStreamWriter(fout, "UTF-16");
        iwrite.write(1013); // Epsilon
        iwrite.write(10); // Newline
        iwrite.write(1013);
        System.out.println("Done");

        iwrite.close();
    }
}
