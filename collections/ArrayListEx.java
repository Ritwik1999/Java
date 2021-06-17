package collections;

import java.util.*;

public class ArrayListEx {
    public static void main(String[] args) {
        ArrayList<String> ll = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            String a = input.nextLine();
            ll.add(a);
        }

        Collections.swap(ll, 2, 5);

        input.close();
    }
}