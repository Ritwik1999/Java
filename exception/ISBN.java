package exception;

import java.util.*;

public class ISBN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();

        try {
            if (s.length() != 9) {
                throw new InvalidInputException("InvalidInputException: ISBN must be exactly 9 digits");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            input.close();
        }

        int number = Integer.parseInt(s);

        NumberManipulation nm = new NumberManipulation();
        nm.extractDigits(number);

        int lastDig = nm.findLastDigit();

        if (lastDig == 10) {
            s += "X";
        } else {
            s += (lastDig % 11);
        }

        System.out.println("ISBN : " + s);
        input.close();
    }
}

class NumberManipulation {
    int arr[] = new int[9];

    public void extractDigits(int n) {
        for (int i = 8; i >= 0; i--) {
            arr[i] = n % 10;
            n = n / 10;
        }
    }

    public int findLastDigit() {
        int ans = 0;

        for (int i = 0; i < 9; i++) {
            ans += (arr[i] * (i + 1));
        }

        return ans;
    }
}

class InvalidInputException extends Exception {
    InvalidInputException(String s) {
        super(s);
    }
}
