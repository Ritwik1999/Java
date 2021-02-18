package arrays;

import java.util.Scanner;

public class BubbleSort {
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

        for (int i = arr.length-1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.print("The sorted array is: ");

        for (int k : arr)
        {
            System.err.print(k + " ");
        }

        System.out.println();

        input.close();
    }
}
