package firstservletproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getMethod();
        if (method.equals("GET")) {
            doGet(request, response);
        } else if (method.equals("POST")) {
            doPost(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // use a database for username and password validation
        try {
            Student s = new Student(username, password);
            boolean isValid = s.validateStudent();
            if (isValid) {
                out.println("Welcome!! " + username + " how have you been?");
            } else {
                out.println("Invalid details entered");
            }
        } catch (Exception e) {
            System.out.println("Exception occurred");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}

class Student {
    private String username;
    private String password;

    public Student(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validateStudent() throws SQLException {
        // establish connection with database
        DBMSConnection connect = null;
        PreparedStatement stmt = null;
        Connection conn = null;
        boolean found = false;
        try {
            connect = new DBMSConnection("jdbc:mysql://localhost:3306/vit", "root", "");
            conn = connect.getConnection();
            String sql = "select * from student where name=? and password=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next() == false) {
                found = false;
            } else {
                found = true;
            }
        } catch (Exception e) {
            System.out.println("Exception occurred");
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        } finally {
            connect.closeConnection(stmt, conn);
        }
        return found;
    }
}