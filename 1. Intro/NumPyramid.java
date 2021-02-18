import java.util.Scanner;

public class NumPyramid {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        n = sc.nextInt();
        
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                System.out.print(j + " ");
            }

            System.out.println();
        }

        for (int i = n-1; i >= 1; i--)
        {
            for (int j = 1; j <= i; j++)
            {
                System.out.print(j + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}
