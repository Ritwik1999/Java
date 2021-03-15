package strings;

import java.util.Scanner;

public class SearchNames {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String names[] = new String[5];

        System.out.println("Enter 5 names:");
        for (int i = 0; i < names.length; i++)
        {
            String name = input.nextLine();
            names[i] = name.split("\\.")[1];
        }

        System.out.print("Enter name to be searched: ");
        String search = input.nextLine().toLowerCase().trim();
        boolean found = false;

        for(String name : names)
        {
            if(name.trim().toLowerCase().equals(search))
            {
                System.out.println("Name found");
                found = true;
                break;
            }
        }

        if(!found)
        {
            System.out.println("Name not found");
        }

        input.close();
    }
}
