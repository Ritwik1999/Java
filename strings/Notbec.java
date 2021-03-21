package strings;

import java.util.Scanner;

public class Notbec {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String regnos[] = new String[5];
        String regno;
        int i = 0;

        while (i < 5) {
            regno = input.next();
            if (!regno.contains("BEC")) {
                continue;
            }

            regnos[i++] = regno;
        }

        sort(regnos);

        for (String id : regnos) {
            System.out.println(id);
        }

        input.close();
    }

    public static void sort(String regnos[]) {
        String temp;
        for (int i = 0; i < regnos.length; i++) {
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