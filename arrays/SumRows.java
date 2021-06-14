package arrays;

import java.util.Scanner;

public class SumRows {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns in the matrix: ");
        int nrow = input.nextInt();
        int ncol = input.nextInt();

        int matrix[][] = new int[nrow][ncol];
        int rsum;

        System.out.println("Enter the elements of the matrix:");

        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        System.out.println("The sum of rows of the matrix is:");

        for (int i = 0; i < nrow; i++) {
            rsum = 0;

            for (int j = 0; j < ncol; j++) {
                rsum += matrix[i][j];
            }

            System.out.println("Sum of row " + (i + 1) + " is: " + rsum);
        }

        input.close();
    }
}
