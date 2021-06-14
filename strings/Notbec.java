package strings;

import java.util.Scanner;

public class Notbec {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String regnos[] = new String[5];
        String regno;
        int i = 0;

        System.out.println("----------Enter Numbers---------");

        while (i < 5) {
            regno = input.next();
            if (!regno.contains("BEC")) {
                continue;
            }

            regnos[i++] = regno;
        }

        sort(regnos);

        System.out.println("----------Sorted Numbers---------");

        for (String id : regnos) {
            System.out.println(id);
        }

        input.close();
    }

    public static void sort(String regnos[]) {
        String temp;
        for (int i = 0; i < regnos.length - 1; i++) {
            for (int j = 0; j < regnos.length - 1 - i; j++) {
                if (regnos[j].compareTo(regnos[j + 1]) > 0) {
                    temp = regnos[j];
                    regnos[j] = regnos[j + 1];
                    regnos[j + 1] = temp;
                }
            }
        }
    }
}