package jdbc;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Scanner;

public class PreparedStmtInsert {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        Scanner input = null;
        try {
            input = new Scanner(System.in);
            System.out.println("Enter your name, password, country, marks");
            String name = input.nextLine();
            String password = input.nextLine();
            String country = input.nextLine();
            int marks= Integer.parseInt(input.nextLine());
            input.close();

            Connection conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vit", "root", "");
            System.out.println("Connection Established");

            String sql = "insert into student values (?,?,?,?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, password);
            stmt.setString(3, country);
            stmt.setInt(4, marks);
            stmt.execute();
            System.out.println("Record inserted");
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Exception occurred");
            System.out.println(e.getMessage());
        }
    }
}
