package arrays;

import java.util.Scanner;

public class Brand {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String brands[] = new String[5];

        System.out.println("\nEnter 5 car brand names:");
        for (int i = 0; i < brands.length; i++) {
            brands[i] = input.nextLine();
        }

        brandSort(brands);
    }

    public static void brandSort(String arr[]) {
        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = 0; j < arr.length-1-i; j++)
            {
                if (arr[j].compareTo(arr[j+1]) < 0)
                {
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println("-----------Sorted names in descending order----------");
        for (String brand: arr) {
            System.out.println(brand);
        }
    }
}
