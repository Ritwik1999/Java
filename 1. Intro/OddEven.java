import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        n = sc.nextInt();

        if (n % 2 == 0)
        {
            System.out.println("The number is even");
        }

        else
        {
            System.out.println("The number is odd");
        }

        sc.close();
    }
}
