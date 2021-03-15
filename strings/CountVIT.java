package strings;

import java.util.Scanner;

public class CountVIT {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();

        if (!text.contains("VIT"))
        {
            System.out.println("No such word in the sentence");
        }

        else
        {
            int count = 0;
            for (int i = 0; i < text.length() - 2; i++)
            {
                String s = text.substring(i, i+3);
                if (s.equals("VIT"))
                {
                    count++;
                }
            }

            System.out.println("VIT occurs " + count + " times in the given input");
        }

        input.close();
    }
}
