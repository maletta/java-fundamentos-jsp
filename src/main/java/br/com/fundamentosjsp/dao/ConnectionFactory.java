package br.com.fundamentosjsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

	public static Connection getConnection()  {
		Connection con = null;
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
			//Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost/fundamentosjsp","postgres", "postgres");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
