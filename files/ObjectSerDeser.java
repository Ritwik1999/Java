/*
    Object Serialization vs De-Serialization

    > Serialization is a mechanism of converting the state of an object (the values of its data members) into a byte stream
    > For Object Serialization, we use the ObjectOutputStream class

    > Deserialization is the reverse process where the byte stream is used to recreate the actual java object in memory
    > For Object De-Serialization, we use the ObjectInputStream class

    > The byte stream created is platform independent. So, the object serialized on one platform can be de-serialized on a different platform 

    NOTE: The class whose objects would be serialized must implement the Serializable interface

    > Transient variables - A transient variable is a variable that can not be serialized.

    > Static variables are not for objects and hence they are not serialized
*/

package files;

import java.io.*;

public class ObjectSerDeser {
    public static void main(String[] args) throws Throwable {
        try {
            Student s = new Student("Ritwik", "18BCE1234");

            // Write the state of the object s to a file
            File obj = new File("files/objectfile.txt");
            ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream(obj));
            objout.writeObject(s);
            objout.close();

            // Read the object s from the file
            ObjectInputStream objin = new ObjectInputStream(new FileInputStream(obj));
            Student s1 = null;
            s1 = (Student) objin.readObject();
            objin.close();

            s1.display();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    String name;
    String regno;
    transient int k; // will not be serialized

    public Student(String name, String regno) {
        this.name = name;
        this.regno = regno;
        k = 55;
    }

    public void display() {
        System.out.println("Student Name: " + name);
        System.out.println("Student Registration Number: " + regno);
        System.out.println(k);
    }
}