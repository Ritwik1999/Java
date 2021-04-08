// for reading and writing primitive data types

package files;

import java.io.*;

public class DataStreamIO {
    public static void main(String[] args) throws Throwable {
        try {
            File obj = new File("files/datafile.txt");
            FileOutputStream fout = new FileOutputStream(obj);
            DataOutputStream dout = new DataOutputStream(fout);
            dout.writeBoolean(true);
            // write an integer to the file - writing 4 bytes of data
            dout.writeInt(13);
            dout.writeUTF("Ritwik Neema");
            dout.close();

            FileInputStream fin = new FileInputStream(obj);
            DataInputStream din = new DataInputStream(fin);
            boolean f = din.readBoolean();
            // read an integer from the file - reading 4 bytes of data
            int k = din.readInt();
            String s = din.readUTF();
            din.close();

            System.out.println(f + " " + k + " " + s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
