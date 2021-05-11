package jdbc;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Scanner;

public class DynamicInsert {
    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, ClassNotFoundException {
        try {
            Scanner input = new Scanner(System.in);
            Student s = new Student();
            s.getStudentDetails(input);
            s.insertStudent();
            input.close();
        } catch (Exception e) {
            System.out.println("Exception occurred");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}

class Student {
    private String name;
    private String password;
    private String country;
    private int marks;

    public void getStudentDetails(Scanner input) {
        System.out.println("Enter your name, password, country, and marks");
        name = input.nextLine();
        password = input.nextLine();
        country = input.nextLine();
        marks = Integer.parseInt(input.nextLine());
    }

    public void insertStudent() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {

        // to get the details of the student from the user and insert a record of those
        // in the database, we use an object of type PreparedStatement

        DBMSConnection dbmsconnect = new DBMSConnection("jdbc:mysql://localhost:3306/vit", "root", "");
        Connection conn = dbmsconnect.getConnection();
        String sql = "insert into student values (?,?,?,?);";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, password);
        stmt.setString(3, country);
        stmt.setInt(4, marks);
        stmt.execute();
        System.out.println("Record inserted");
        dbmsconnect.closeConnection(conn, stmt);
    }
}

class DBMSConnection {
    String url;
    String username;
    String password;

    DBMSConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        conn = DriverManager.getConnection(url, username, password);
        System.out.println("Connection Established");
        return conn;
    }

    public void closeConnection(Connection conn, Statement stmt) throws SQLException {
        conn.close();
        stmt.close();
        System.out.println("Connection closed");
    }
}