package strings;

import java.util.Scanner;

public class RegNums {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String regnos[] = new String[5];

        System.out.println("\nEnter 5 registration numbers: ");

        for (int i = 0; i < regnos.length; i++) {
            regnos[i] = input.nextLine();
        }

        int count_scope = 0, count_sense = 0;

        for (int i = 0; i < regnos.length; i++) {
            if (regnos[i].contains("BCE")) {
                count_scope++;
            }

            else if (regnos[i].contains("BEC")) {
                count_sense++;
            }

            else {
                continue;
            }
        }

        if (count_scope == 0 && count_sense == 0) {
            System.out.println("There are no students from SCOPE and SENSE school\n");
        }

        else {
            System.out.println("SCOPE count: " + count_scope);
            System.out.println("SENSE count: " + count_sense);
            System.out.println();
        }

        input.close();
    }
}