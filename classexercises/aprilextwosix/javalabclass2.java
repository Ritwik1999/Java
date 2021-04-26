package classexercises.aprilextwosix;

import java.util.*; // was not in the question
import java.io.*; // was not in the question

public class javalabclass2 {
    public static void main(String[] args) {
        // The code was not in a try catch block in the question
        try {
            shape s[] = new shape[4];
            s[0] = new shape();
            s[0].setShapeDetails();
            s[0].display_details();
            s[0].display_shapename();
            s[0].write_datatoFile();
        } catch (IOException e) {
            System.out.println("IO Exception occurred");

            if (e instanceof FileNotFoundException) {
                System.out.println("The file to write to was not found");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input given");
        } catch (Exception e) {
            System.out.println("Generic Exception occurred");
            System.out.println(e.getMessage());
        }
    }
}

class shape {
    int numsides;
    double area;
    String shapename;

    public void setShapeDetails() throws InputMismatchException {
        Scanner input = new Scanner(System.in);

        // The shapename was never input in the question
        System.out.println("Enter shape name");
        this.shapename = input.nextLine();
        System.out.println("Enter the number of sides");
        this.numsides = input.nextInt(); // Semicolon was missing in the question
        System.out.println("Enter the area");
        this.area = input.nextDouble();

        // input was never closed in the question
        input.close();
    }

    public void display_details() {
        System.out.println(numsides);
        System.out.println(area);
    }

    public void display_shapename() {
        if (this.shapename.equals("circle")) {
            System.out.println("its a circle");
        }
    }

    public void write_datatoFile() throws IOException {
        File f = new File("satish.txt");
        FileOutputStream fout = new FileOutputStream(f);
        fout.write(numsides);
        fout.close();
    }
}
