/*
    > The DataOutputStream lets an application write primitive Java data types to an output stream in a portable way
    > Constructor: DataOutputStream(OutputStream out)
    > The Application can then use DataInputStream to read the data back in.
    > The DataInputStream let an application read primitive Java data types from an underlying input stream in a machine-independent way
    > Constructor: DataInputStream(InputStream in)
*/
package files.primitivefiles;

import java.io.*;

public class DataStreamIO {
    public static void main(String[] args) {
        try {
            File obj = new File("files/primitivefiles/datafile.txt");
            FileOutputStream fout = new FileOutputStream(obj, true);
            DataOutputStream dout = new DataOutputStream(fout);
            dout.writeBoolean(true);
            // write an integer to the file - writing 4 bytes of data
            dout.writeInt(13);
            dout.writeUTF("Ritwik Neema 18BCE2166");
            dout.close();

            FileInputStream fin = new FileInputStream(obj);
            DataInputStream din = new DataInputStream(fin);
            boolean f = din.readBoolean();
            // read an integer from the file - reading 4 bytes of data
            int k = din.readInt();
            String s = din.readUTF();
            din.close();

            System.out.println("\n" + f + " " + k + " " + s);
        } catch (Exception e) {
            System.out.println("Exception occurred");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}