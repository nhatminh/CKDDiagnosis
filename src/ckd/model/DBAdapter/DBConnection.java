package ckd.model.DBAdapter;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection connection;

	public static Connection getConnection() {
		String dbName = "ckd";
		String userName = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
