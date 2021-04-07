/*
    Why Files?
    1. Small number of records
    2. Persistent storage
    3. Data doesn't change frequently;
    4. Not much (concurrent) users.
    5. Security

    Files are modeled as objects. Hence, before using them, we need to create a File Object
    > An abstract representation of file and directory pathnames
    File Class Constructors
    > File(String Path) (Path can be absolute or relative. It is an abstract path, i.e., machine independent, it is resolved to a machine specific path internally)
    > File(String Parent, String Child)
    > File(File Parent, String Child)

    Java has a File Class
*/

package files;

import java.io.File;

public class FilesIntro {
    public static void main(String[] args) throws Throwable {
        // Constructor 1
        File obj = new File("test.txt");    // This does not check if the file exists, it just creates a file object
        System.out.println(obj.length());
        System.out.println(File.separator); // Machine specific path delimiter, for Windows, it is \
        System.out.println(obj.getName());
        System.out.println(obj.getParent());
        System.out.println(obj.getAbsolutePath());

        // Constructor 2
        File obj2 = new File("/home/ritwik/Desktop/Sem 6/Java/files", "test2.txt");
        System.out.println("Is absolute? " + obj2.isAbsolute());
        System.out.println("Can Read? " + obj2.canRead());
        System.out.println("Can Write? " + obj2.canWrite());
        System.out.println("Does file exist? " + obj2.exists());
        if (obj2.createNewFile()) {
            System.out.println("File Created");
        } else {
            System.out.println("File already exists");
        }
        System.out.println("File Deleted? " + obj2.delete());

        // Constructor 3, using a Directory as a File Object
        File obj3 = new File("/home/ritwik/Desktop/Sem 6/Java/files");
        System.out.println("Is directory? " + obj3.isDirectory());
        File obj4 = new File(obj3, "test.txt");
        System.out.println(obj4.getAbsolutePath());
        System.out.println("Is file? " + obj4.isFile());

        File obj5 = new File("/home/ritwik/Desktop/Sem 6/Java");
        String names[] = obj5.list();
        System.out.println("-----All files in the Java directory as Strings------");
        for (String name : names) {
            System.out.println(name);
        }

        File files[] = obj5.listFiles();
        System.out.println("-----All files in the Java directory as File objects------");
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
