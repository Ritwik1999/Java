<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page JSP</title>
</head>
<body>

	<form action="login.jsp" method="post">
		<label> Enter your name: <input type="text" name="username"
			required></label><br> <label> Enter your password: <input
			type="password" name="password" required></label><br> <label>
			Select your country: <select name="country">
				<option value="India" selected>India</option>
				<option value="US">US</option>
				<option value="UK">UK</option>
		</select>
		</label> <br> <label> Enter your mark: <input type="text"
			name="mark" required></label><br> <br> <input type="submit"
			name="submit" value="submit">

	</form>

	<%!class Student {
		private String username;
		private String password;
		private String country;
		private int mark;

		public Student(String username, String password, String country, int mark) {
			this.username = username;
			this.password = password;
			this.country = country;
			this.mark = mark;
		}

		public boolean insertStudentRecord() {
			// establish a database connection
			DBMSConnection connect = null;
			Connection conn = null;
			PreparedStatement stmt = null;
			boolean insert = false;
			try {
				connect = new DBMSConnection("jdbc:mysql://localhost:3306/vit", "root", "");
				conn = connect.getConnection();
				String sql = "insert into student values (?,?,?,?);";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, username);
				stmt.setString(2, password);
				stmt.setString(3, country);
				stmt.setInt(4, mark);
				int affectedRows = stmt.executeUpdate();
				if (affectedRows > 0) {
					insert = true;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return insert;
		}
	}

	class DBMSConnection {
		String url;
		String username;
		String password;

		public DBMSConnection(String url, String username, String password) {
			this.url = url;
			this.username = username;
			this.password = password;
		}

		public Connection getConnection() {
			Connection conn = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
				conn = DriverManager.getConnection(url, username, password);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return conn;
		}

		public void closeConnection(Statement stmt, Connection conn) throws SQLException {
			stmt.close();
			conn.close();
		}
	}%>

	<%
	// This code rests on the server, when the client submits the form, it executes and sends the response back
	String submit = request.getParameter("submit");
	if (submit != null) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String country = request.getParameter("country");
		String mark = request.getParameter("mark");
		try {
			Student s = new Student(username, password, country, Integer.parseInt(mark));
			boolean inserted = s.insertStudentRecord();
			if (inserted) {
				out.print("Record inserted successfully");
			} else {
				out.print("Record was not inserted");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	%>
</body>
</html>