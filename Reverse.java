import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        n = sc.nextInt();

        for (int i = n; i > 0; i--) {
            System.out.print(i);
            System.out.print(" ");
        }

        System.out.println();

        sc.close();
    }
}
