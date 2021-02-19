package strings;

import java.util.Scanner;

public class SortedNames {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String names[] = new String[5];
        String temp;

        System.out.println("-----------------------");
        System.out.println("Enter 5 names:");
        System.out.println("-----------------------");
        
        for (int i = 0; i < 5; i++)
        {
            names[i] = input.nextLine();
        }

        // Bubble Sort
        for (int i = 0; i < names.length; i++)
        {
            for (int j = 0; j < names.length-1-i; j++)
            {
                if (names[j].compareTo(names[j+1]) > 0)
                {
                    temp = names[j];
                    names[j] = names[j+1];
                    names[j+1] = temp;
                }
            }
        }

        System.out.println("-----------------------");
        System.out.println("Sorted names:");
        System.out.println("-----------------------");
        for (String name : names)
        {
            System.out.println(name);
        }

        input.close();
    }
}
