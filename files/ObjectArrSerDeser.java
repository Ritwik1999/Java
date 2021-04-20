package files;

import java.util.*;
import java.io.*;

public class ObjectArrSerDeser {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Create an array of Stu objects and serialize them to a file.
        // Deserialize them and print their details

        Scanner input = new Scanner(System.in);
        String name;
        String regno;

        File obj = new File("files/objectarrfile.txt");
        FileOutputStream fout = new FileOutputStream(obj);  // throws FileNotFoundException (FileNotFoundException extends IOException)
        ObjectOutputStream objout = new ObjectOutputStream(fout);   // throws IOException

        Stu students[] = new Stu[3];
        for (int i = 0; i < students.length; i++) {
            System.out.println("Enter student name, and regno:");
            name = input.nextLine(); 
            regno = input.nextLine(); 

            students[i] = new Stu(name, regno);
            objout.writeObject(students[i]);
        }
        input.close();

        objout.writeObject(new endoffile());    // Write an end of file object
        objout.close();

        // read the objects from the file
        FileInputStream fin = new FileInputStream(obj);
        ObjectInputStream objin = new ObjectInputStream(fin);

        Object myobj = null;
        while (true) {
            myobj = objin.readObject();     // throws IOException, and ClassNotFoundException
            if (myobj instanceof endoffile) {
                break;
            } else {
                ((Stu)myobj).display();
            }    
        }

        objin.close();
    }
}

class Stu implements Serializable {
    String name;
    String regno;

    Stu(String name, String regno) {
        this.name = name;
        this.regno = regno;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Reg no: " + regno);
    }
}

class endoffile implements Serializable {

}
