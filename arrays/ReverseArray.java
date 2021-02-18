package arrays;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        n = input.nextInt();

        int arr[] = new int[n];

        System.out.print("Enter the elements of the array: ");

        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = input.nextInt();
        }

        System.out.print("Reverse array is: ");

        int temp;

        for (int k = 0; k < n/2; k++)
        {
            temp = arr[k];
            arr[k] = arr[n-1-k];
            arr[n-1-k] = temp;
        }

        for (int ele : arr)
        {
            System.out.print(ele + " ");
        }

        System.out.println();

        input.close();
    }
}
