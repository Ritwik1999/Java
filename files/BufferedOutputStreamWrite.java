package files;

import java.io.*;

public class BufferedOutputStreamWrite {
    public static void main(String[] args) throws Throwable{
        BufferedInputStream bufin = new BufferedInputStream(System.in);
        int data = bufin.read();
        bufin.close();

        BufferedOutputStream bufout = new BufferedOutputStream(System.out);
        bufout.write(data);
        bufout.close();
    }
}
