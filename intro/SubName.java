package intro;

import java.util.Scanner;

public class SubName {
    public static void main(String[] args) {
        int roomNo;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the room number: ");
        roomNo = sc.nextInt();

        switch (roomNo) {
            case 823:
                System.out.println("Java Programming");
                break;

            case 824:
                System.out.println("Python Programming");
                break;

            default:
                System.out.println("Invalid input");
                break;
        }

        sc.close();
    }
}
