package strings;

import java.util.Scanner;
import java.util.HashMap;

public class StrBinHex {

    public static String str2hex(String s) {
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int num = (int) c;

            String subAns = Integer.toHexString(num);

            ans += subAns;
        }

        return ans;
    }

    public static String reverse(String s) {
        char a[] = s.toCharArray();
        int l, r = 0;
        r = a.length - 1;

        for (l = 0; l < r; l++, r--) {
            char temp = a[l];
            a[l] = a[r];
            a[r] = temp;
        }

        return String.valueOf(a);
    }

    public static String str2bin(String s) {
        int len = s.length();
        String bin = "";

        for (int i = 0; i < len; i++) {
            int val = Integer.valueOf(s.charAt(i));

            while (val > 0) {
                if (val % 2 == 1) {
                    bin += '1';
                }

                else {
                    bin += '0';
                }

                val /= 2;
            }

            bin = reverse(bin);
        }

        return bin;
    }

    public static String hex2bin(String hex) {
        String binary = "";
        hex = hex.toUpperCase();

        HashMap<Character, String> codes = new HashMap<Character, String>();

        codes.put('0', "0000");
        codes.put('1', "0001");
        codes.put('2', "0010");
        codes.put('3', "0011");
        codes.put('4', "0100");
        codes.put('5', "0101");
        codes.put('6', "0110");
        codes.put('7', "0111");
        codes.put('8', "1000");
        codes.put('9', "1001");
        codes.put('A', "1010");
        codes.put('B', "1011");
        codes.put('C', "1100");
        codes.put('D', "1101");
        codes.put('E', "1110");
        codes.put('F', "1111");

        int i;
        char ch;

        for (i = 0; i < hex.length(); i++) {
            ch = hex.charAt(i);
            binary += codes.get(ch);
        }

        return binary;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text;

        System.out.print("\nEnter text: ");
        text = input.nextLine();

        System.out.println("String -> Binary: \n" + str2bin(text));

        String res = str2hex(text);
        System.out.println("String -> Hex: " + res);

        System.out.println("Hex -> Binary: \n" + hex2bin(res) + '\n');

        input.close();
    }
}
