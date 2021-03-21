package strings;

import java.util.Scanner;

public class StrBinHex {

    public static String ascii2hex(String s) {
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

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text;

        text = input.nextLine();

        System.out.println("Binary: \n" + str2bin(text));

        String res = ascii2hex(text);
        System.out.println("Hex -> Binary: \n" + str2bin(res));

        input.close();
    }
}
