package arrays;

import java.util.Scanner;

public class DupRemovalInSortedArray {
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

        int j = 0;

        for (int i = 0; i < n-1; i++)
        {
            if (arr[i] != arr[i+1])
            {
                arr[j++] = arr[i];
            }
        }

        arr[j++] = arr[n-1];

        System.out.print("Array without duplicates is: ");

        for (int k = 0; k < j; k++)
        {
            System.out.print(arr[k] + " ");
        }

        System.out.println();

        input.close();
    }    
}
