package firstservletproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMSConnection {
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
			System.out.println("Exception occurred; here");
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public void closeConnection(Statement stmt, Connection conn) throws SQLException {
		stmt.close();
		conn.close();
	}
}