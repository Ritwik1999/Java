/*
    A ResultSet object (say, rs), among other methods has two boolean methods - rs.next() and rs.previous(). They return false when there are no more records to read
    NOTE: rs.previous() will throw an exception with the following message
        Operation not allowed for a result set of type ResultSet.TYPE_FORWARD_ONLY.
    To be able to use it, pass ResultSet.TYPE_SCROLL_INSENSITIVE as an argument while calling the Connection.createStatement method.

    NOTE: A ResultSet Object is like a cursor, once rs.next() (or rs.previous()) is called, it scrolls to the next (or previous) element.
*/

package jdbc;

import java.sql.*;

public class Read {
    public static void main(String[] args) {
        try {
            Connection conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vit", "root", "");
            System.out.println("Connection Established");

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            // fetch record(s)
            ResultSet rs = stmt.executeQuery("select * from student;");

            if (rs.next() == false) {
                System.out.println("No matching records found");
            } else {
                rs.previous();
                System.out.println("Table records");
                System.out.println("------------------------------------------------------------------------------");
                while (rs.next()) {
                    System.out.printf("%20s\t", rs.getString(1));
                    System.out.printf("%20s\t", rs.getString(2));
                    System.out.printf("%20s\t", rs.getString(3));
                    System.out.printf("%20d\n", rs.getInt(4));
                }
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