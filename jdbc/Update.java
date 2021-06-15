/*
    int executeUpdate(String sql) -- Returns: either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
*/

package jdbc;

import java.sql.*;

public class Update {
    public static void main(String[] args) {
        try {
            Connection conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vit", "root", "");
            System.out.println("Connection Established");

            Statement stmt = conn.createStatement();
            int rowsAffected;

            // updating a record
            String sql = "update student set password='newpass',country='NZ' where name='Ritwik Neema';";
            rowsAffected = stmt.executeUpdate(sql);
            System.out.println(rowsAffected + " record updated");

            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Exception occurred");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}