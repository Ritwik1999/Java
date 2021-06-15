package firstservletproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
    public ReadServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            renderRecords(out);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void renderRecords(PrintWriter out) throws SQLException {
        DBMSConnection connect = null;
        Statement stmt = null;
        Connection conn = null;
        try {
            connect = new DBMSConnection("jdbc:mysql://localhost:3306/vit", "root", "");
            conn = connect.getConnection();
            // Switch to student2 table to test the no records condition
            String sql = "select * from student1;";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next() == false) {
                out.println("<h3>There are no records in the database</h3>");
            } else {
                int count = 0;
                out.println(
                        "<table border='1'><thead><tr><th>S.No.</th><th>Name</th><th>Password</th><th>Gender</th><th>Subjects</th><th>Country</th></tr></thead><tbody>");
                do {
                    count++;
                    out.println("<tr><td>" + count + "</td><td>" + rs.getString(1) + "</td><td>" + rs.getString(2)
                            + "</td><td>" + rs.getString(3) + "</td><td>" + rs.getString(4) + "</td><td>"
                            + rs.getString(5) + "</td></tr>");
                } while (rs.next());
                out.println("</tbody></table>");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            connect.closeConnection(stmt, conn);
        }
    }
}
