package jdbc;

import java.sql.*;

public class JDBCIntro {
    public static void main(String[] args) {
        // connecting java program to a database
        try {
            Connection conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vit", "root", "");
            System.out.println("Connection Established");
            conn.close();
        } catch (Exception e) {
            System.out.println("Exception occurred");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}
