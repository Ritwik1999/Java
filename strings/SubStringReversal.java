package strings;

import java.util.Scanner;

public class SubStringReversal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter text:");
        String str = input.nextLine();
        String words[] = str.split(" ");

        str = "";

        for (int l = 0; l < words.length; l++)
        {
            String word = words[l];
            for (int i = word.length()-1; i >= 0; i--)
            {
                str = str + word.substring(i, i+1);
            }

            if (l != words.length - 1)
            {
                str = str + " ";
            }
        }

        System.out.println("\nText with words reversed: ");
        System.out.println(str);

        input.close();
    }
}
