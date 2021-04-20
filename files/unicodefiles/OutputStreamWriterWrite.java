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
        iwrite.write(10);
        iwrite.write(10);
        iwrite.close();

        FileOutputStream fout2 = new FileOutputStream(obj, true);
        OutputStreamWriter iwrite2 = new OutputStreamWriter(fout2, "UTF-16");
        iwrite2.write(999);
        iwrite2.write(10);
        iwrite2.write(999);
        iwrite2.close();

        System.out.println("Done");
    }
}
