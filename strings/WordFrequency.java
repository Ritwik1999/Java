package strings;

import java.util.Scanner;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter text: ");

        String text = input.nextLine();
        String words[] = text.split(" ");
        String unique = "";

        int startFrom, wordCount, ind;

        for (String word : words) {
            startFrom = 0;
            wordCount = 0;

            if (unique.indexOf(word) == -1) {
                while ((ind = text.indexOf(word, startFrom)) != -1) {
                    wordCount += 1;
                    startFrom = word.length() + ind;
                }

                unique = unique.concat(word + " ");

                System.out.println("Frequency of " + word + " is: " + wordCount);
            }
        }

        input.close();
    }
}
