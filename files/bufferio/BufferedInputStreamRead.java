/*
    Mark Method: the general contract of mark is that, if the method markSupported
    returns true the stream remembers all the bytes read after the call to mark
    and stands ready to supply the same bytes again if and whenever the reset method is
    called.
    
    However, the stream is not required to remember any data at all if more than read
    limit bytes are read from the stream before reset is called.

    These streams generally improve performance
*/

package files.bufferio;

import java.io.*;

public class BufferedInputStreamRead {
    public static void main(String[] args) {
        try {
            BufferedInputStream bufin = new BufferedInputStream(System.in);
            int data = bufin.read(); // reads one byte from the buffer, i.e. h in hello
            System.out.println((char) data);

            byte b[] = new byte[4];
            bufin.read(b); // reads 4 bytes from the buffer, e.g., ello in hello
            for (byte c : b) {
                System.out.println((char) c);
            }

            bufin = new BufferedInputStream(System.in);
            data = bufin.read();
            // Mark after the first byte read, for a maximum of 3 bytes
            bufin.mark(3);
            byte b1[] = new byte[4];
            bufin.read(b1);
            bufin.reset();
            data = bufin.read();
            System.out.println("Read after reset: " + (char) data);

            bufin.close();
        } catch (Exception e) {
            System.out.println("Exception occurred");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}
