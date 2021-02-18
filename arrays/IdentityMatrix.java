package arrays;

import java.util.Scanner;

public class IdentityMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the order of Identity Matrix: ");
        int order = input.nextInt();

        int matrix[][] = new int[order][order];
        boolean is_identity = true;

        System.out.println("Enter the elements of the matrix:");

        for (int i = 0; i < order; i++)
        {
            for (int j = 0; j < order; j++)
            {
                matrix[i][j] = input.nextInt();
            }
        }

        for (int i = 0; i < order; i++)
        {
            for (int j = 0; j < order; j++)
            {
                if ((i != j && matrix[i][j] != 0) || (i == j && matrix[i][j] != 1))
                {
                    is_identity = false;
                    break;
                }
            }
        }

        if (!is_identity)
        {
            System.out.println("Not an identity matrix");
        }

        else
        {
            System.out.println("The entered matrix is an identity matrix");
        }

        input.close();
    }
}
