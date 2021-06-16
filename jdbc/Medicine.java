package jdbc;

import java.io.*;
import java.sql.*;

public class Medicine {
    public static void main(String[] args) {
        File obj = new File("tablet_file.txt");
        File obj2 = new File("syrup_file.txt");
        try {

            Connection conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vit", "root", "");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Medicine where Type='Tablet' and Price>500;");

            if (rs.next() == false) {
                System.out.println("No matching records found");
            } else {
                FileOutputStream fout = new FileOutputStream(obj, true);
                DataOutputStream dout = new DataOutputStream(fout);
                do {
                    dout.writeUTF(rs.getString(1));
                    dout.writeUTF(rs.getString(2));
                    dout.writeUTF(rs.getString(3));
                    dout.writeUTF(rs.getString(4));
                    dout.writeUTF(rs.getString(5));
                    dout.writeInt(rs.getInt(6));
                } while (rs.next());
                dout.close();
            }
            stmt.close();

            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from Medicine where Type='Syrup' and Price>200;");

            if (rs.next() == false) {
                System.out.println("No matching records found");
            } else {
                FileOutputStream fout = new FileOutputStream(obj2, true);
                DataOutputStream dout = new DataOutputStream(fout);
                do {
                    dout.writeUTF(rs.getString(1));
                    dout.writeUTF(rs.getString(2));
                    dout.writeUTF(rs.getString(3));
                    dout.writeUTF(rs.getString(4));
                    dout.writeUTF(rs.getString(5));
                    dout.writeInt(rs.getInt(6));
                } while (rs.next());
                dout.close();
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