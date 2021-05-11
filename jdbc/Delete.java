/*
    int executeUpdate(String sql) -- Returns: either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
*/

package jdbc;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Delete {
    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, ClassNotFoundException {
        try {
            Connection conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vit", "root", "");
            System.out.println("Connection Established");

            Statement stmt = conn.createStatement();
            int rowsAffected;

            // deleting a record
            rowsAffected = stmt.executeUpdate("delete from student where name='Test';");
            System.out.println(rowsAffected + " record(s) deleted");

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Exception occurred");
            System.out.println(e.getMessage());
        }
    }
}