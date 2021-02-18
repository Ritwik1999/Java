import java.util.Scanner;

public class Natural {
    public static void main(String[] args) {
        int n, sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }

        System.out.print("Sum is: ");
        System.out.println(sum);

        sc.close();
    }
}