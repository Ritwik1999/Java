package strings;

import java.util.Scanner;

public class CountryCapital {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String country = input.nextLine();

        switch (country) {
        case "India":
            System.out.println("Delhi");
            break;

        case "USA":
            System.out.println("Washington DC");
            break;

        case "Australia":
            System.out.println("Canberra");
            break;

        case "New Zealand":
            System.out.println("Wellington");
            break;

        case "UAE":
            System.out.println("Abu Dhabi");
            break;

        default:
            System.out.println("Please check your Country Name");
        }
        input.close();
    }
}
