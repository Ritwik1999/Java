import java.util.Scanner;

public class StarInvertedTriangle {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        n = sc.nextInt();
        
        for (int i = 1; i <= n; i++)
        {
            for (int j = n; j >= i; j--)
            {
                System.out.print("* ");
            }

            System.out.println();
        }

        sc.close();
    }
}
