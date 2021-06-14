package arrays;

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        n = input.nextInt();

        int arr[] = new int[n];

        System.out.print("Enter the elements of the array: ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }

        System.out.print("Enter the element to be searched: ");
        int elem = input.nextInt();
        boolean found = false;

        for (int e : arr) {
            if (e == elem) {
                System.out.println("The element is present in the array.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("The element is not present in the array.");
        }

        input.close();

    }
}
