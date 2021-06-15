package jdbc;

import java.sql.*;

public class ReadAlter {
    public static void main(String[] args) {
        try {
            Connection conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vit", "root", "");
            System.out.println("Connection Established");

            Statement stmt = conn.createStatement();

            // fetch record(s)
            ResultSet rs = stmt.executeQuery("select * from student;");

            if (rs.next() == false) {
                System.out.println("No matching records found");
            } else {
                System.out.println("Table records");
                System.out.println("------------------------------------------------------------------------------");
                do {
                    System.out.printf("%20s\t", rs.getString(1));
                    System.out.printf("%20s\t", rs.getString(2));
                    System.out.printf("%20s\t", rs.getString(3));
                    System.out.printf("%20d\n", rs.getInt(4));
                } while (rs.next());
                System.out.println("------------------------------------------------------------------------------");
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Exception occurred");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}