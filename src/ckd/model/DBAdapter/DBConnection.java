package ckd.model.DBAdapter;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public Connection connection;

	public Connection getConnection() {
		String dbName = "ckd";
		String userName = "root";
		String password = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
