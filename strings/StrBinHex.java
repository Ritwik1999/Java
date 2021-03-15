package strings;

import java.util.Scanner;

public class StrBinHex {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text;

        text = input.nextLine();

        String bintext = hextobin(strtohex(text));

        System.out.println(bintext);

        input.close();
    }

    public static String strtohex(String s) {

        String hex = "";

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            int in = (int) ch;
            String part = Integer.toHexString(in);
            hex += part;
        }

        return hex;
    }

    public static String hextobin(String hex) {
        int i = Integer.parseInt(hex, 16);
        String bin = Integer.toBinaryString(i);
        return bin;
    }
}
