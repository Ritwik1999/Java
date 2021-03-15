package arrays;

import java.util.Scanner;

public class PassCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number of semesters: ");
        int nrow = input.nextInt();

        int marks[][] = new int[nrow][];

        for (int i = 0; i < nrow; i++)
        {
            System.out.print("How many subjects in semester " + (i+1) + ": ");
            int ncol = input.nextInt();
            marks[i] = new int[ncol];
            System.out.print("Enter marks of " + ncol + " subjects: ");

            for (int j = 0; j < ncol; j++)
            {
                marks[i][j] = input.nextInt();
            }
        }

        countpass(marks);

        input.close();
    }

    public static void countpass(int marks[][])
    {
        int pass_count = 0;
        int fail_count = 0;

        for (int submarks[] : marks)
        {
            for (int mark : submarks)
            {
                if (mark >= 40)
                    pass_count++;

                else
                    fail_count++;
            }
        }
        
        System.out.println();
        System.out.println("The student has passed in " + pass_count + " subjects");
        System.out.println("The student has failed in " + fail_count + " subjects");
    }
}
