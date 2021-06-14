package arrays;

import java.util.Scanner;

public class AddTwoMats {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns in the matrix: ");
        int nrow = input.nextInt();
        int ncol = input.nextInt();

        int matrix1[][] = new int[nrow][ncol];
        int matrix2[][] = new int[nrow][ncol];

        System.out.println("Enter the elements of the first matrix:");

        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                matrix1[i][j] = input.nextInt();
            }
        }

        System.out.println("Enter the elements of the second matrix:");

        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                matrix2[i][j] = input.nextInt();
            }
        }

        System.out.println("The addition matrix is: ");

        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                System.out.print(matrix1[i][j] + matrix2[i][j] + " ");
            }

            System.out.println();
        }

        input.close();
    }
}
