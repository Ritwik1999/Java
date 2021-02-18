import java.util.Scanner;

public class Digits {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        n = sc.nextInt();

        System.out.println("Last digit is: " + (n % 10));

        while(n > 10)
        {
            n = n / 10;
        }

        System.out.println("First digit is: " + n);

        sc.close();
    }
}
