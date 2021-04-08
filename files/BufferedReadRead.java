package files;

import java.io.*;

public class BufferedReadRead {
    public static void main(String[] args) throws Throwable{
        BufferedReader bufread = new BufferedReader(new InputStreamReader(System.in));
        int data = bufread.read();
        System.out.println((char)data);
        bufread.close();

        BufferedWriter bufwrite = new BufferedWriter(new OutputStreamWriter(System.out));
        bufwrite.write(data);
        System.out.println((char)data);
    }
}
