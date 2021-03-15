package strings;

import java.util.*;

public class CountVowels {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text;
        int countVowels = 0;

        System.out.print("Enter text: ");
        text = input.nextLine().toLowerCase();

        for (int i = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            {
                countVowels++;
            }
        }

        System.out.println("Number of vowels: " + countVowels);
        input.close();    
    }
}
