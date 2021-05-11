package jdbc;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Scanner;

public class DynamicCRUDapp {
    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, ClassNotFoundException {

        try {
            Student s = new Student();
            Scanner sc = new Scanner(System.in);
            int choice = 0;
            do {
                System.out.println("-----------------------------------------------------");
                System.out.println("Select an option");
                System.out.println("1-Registration\n2-Update Password\n3-Delete\n4-Search for a student\n5-Exit");
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        s.getStudentDetails();
                        s.insertStudentRecord();
                        break;
                    case 2:
                        s.updateStudentPassword();
                        break;
                    case 3:
                        s.deleteStudentRecord();
                        break;
                    case 4:
                        s.searchStudentRecord();
                        break;
                    case 5:
                        System.out.println("See you soon");
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            } while (choice != 5);
            sc.close();
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
    private static final Scanner input = new Scanner(System.in);

    public void getStudentDetails() {
        System.out.println("Enter your name, password, country, and marks");
        name = input.nextLine();
        password = input.nextLine();
        country = input.nextLine();
        marks = Integer.parseInt(input.nextLine());
    }

    public void insertStudentRecord() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {

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

    public void updateStudentPassword() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {

        DBMSConnection dbmsconnect = new DBMSConnection("jdbc:mysql://localhost:3306/vit", "root", "");
        Connection conn = dbmsconnect.getConnection();

        System.out.print("Enter your name: ");
        String inputName = input.nextLine();
        System.out.print("Enter new password: ");
        String inputPassword = input.nextLine();

        String sql = "update student set password=? where name=?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, inputPassword);
        stmt.setString(2, inputName);
        int affectedRows = stmt.executeUpdate();

        if (affectedRows > 0) {
            System.out.println("Password changed successfully");
        } else {
            System.out.println("No matching records found in the database");
        }

        dbmsconnect.closeConnection(conn, stmt);
    }

    public void deleteStudentRecord() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {

        DBMSConnection dbmsconnect = new DBMSConnection("jdbc:mysql://localhost:3306/vit", "root", "");
        Connection conn = dbmsconnect.getConnection();

        System.out.print("Enter student whose record is to be deleted: ");
        String inputName = input.nextLine();

        String sql = "delete from student where name=?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, inputName);
        int affectedRows = stmt.executeUpdate();

        if (affectedRows > 0) {
            System.out.println("Record deleted successfully");
        } else {
            System.out.println("No matching records found in the database");
        }

        dbmsconnect.closeConnection(conn, stmt);
    }

    public void searchStudentRecord() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {

        DBMSConnection dbmsconnect = new DBMSConnection("jdbc:mysql://localhost:3306/vit", "root", "");
        Connection conn = dbmsconnect.getConnection();

        System.out.print("Enter student whose record is to be searched: ");
        String inputName = input.nextLine();

        String sql = "select * from student where name=?;";
        PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        stmt.setString(1, inputName);
        ResultSet rs = stmt.executeQuery();

        if (rs.next() == false) {
            System.out.println("No matching records found in the database");
        } else {
            rs.previous();
            while (rs.next()) {
                System.out.println("Record found:");
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getString(3) + "\t");
                System.out.print(rs.getInt(4) + "\n");
            }
        }

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