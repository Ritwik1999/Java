package oops;

import java.util.Scanner;

public class Mobile {

    String model;
    String company;
    int price;
    String yearOfManufacture;

    void set_mobileDetails()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Mobile model, company, price, and year of manufacture:");

        model = input.nextLine();
        company = input.nextLine();
        price = Integer.parseInt(input.nextLine());
        yearOfManufacture = input.nextLine();
    }

    static void sort_mobileDetails(Mobile mobiles[])
    {
        for (int i = 0; i < mobiles.length - 1; i++)
        {
            for (int j = 0; j < (mobiles.length - 1 - i); j++)
            {
                if (mobiles[j].company.compareTo(mobiles[j+1].company) > 0)
                {
                    Mobile temp = mobiles[j];
                    mobiles[j] = mobiles[j+1];
                    mobiles[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < mobiles.length; i++)
        {
            mobiles[i].display_mobileDetails();
        }
    }

    void display_mobileDetails()
    {
        System.out.println("----------");
        System.out.println("Model: " + model);
        System.out.println("Company: " + company);
        System.out.println("Price: " + price);
        System.out.println("Year of Manufacture: " + yearOfManufacture);
        System.out.println("----------");
    }

    public static void main(String[] args) {
        Mobile mobiles[] = new Mobile[5];

        for (int i = 0; i < mobiles.length; i++)
        {
            mobiles[i] = new Mobile();
            mobiles[i].set_mobileDetails();
        }

        Mobile.sort_mobileDetails(mobiles);
    }    
}
