package strings;

import java.util.Scanner;

public class CountryCapital {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter Country name: ");
        String country = input.nextLine();

        switch (country) {
            case "India":
                System.out.println("New Delhi\n");
                break;

            case "USA":
                System.out.println("Washington DC\n");
                break;

            case "Australia":
                System.out.println("Canberra\n");
                break;

            case "New Zealand":
                System.out.println("Wellington\n");
                break;

            case "UAE":
                System.out.println("Abu Dhabi\n");
                break;

            default:
                System.out.println("Please check your Country Name\n");
        }
        input.close();
    }
}
