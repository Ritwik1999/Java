package arrays;

import java.util.Scanner;

public class Transpose {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns in the matrix: ");
        int nrow = input.nextInt();
        int ncol = input.nextInt();

        int matrix[][] = new int[nrow][ncol];

        System.out.println("Enter the elements of the matrix:");

        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        System.out.println("The transpose of the matrix is:");

        for (int j = 0; j < ncol; j++) {
            for (int i = 0; i < nrow; i++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }

        input.close();
    }
}
