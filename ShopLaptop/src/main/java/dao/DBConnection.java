package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection connection() {
		Connection connection=null;
		String url="jdbc:mysql://localhost:3306/shop_laptop";
		String user="root";
		String password="123456";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Susscess");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}
	public static void main(String[] args) {
		DBConnection.connection();
	}
}
