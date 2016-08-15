package com.blogspot.sontx.tut.dbdemo;

import java.sql.*;

public class SelectSample {

	public static void main(String[] args) throws ClassNotFoundException {
		// step 1: load driver
		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		try {
			// step 2: create a database connection
			connection = DriverManager.getConnection("jdbc:sqlite:sample.db");

			// step 3: work with your database
			Statement statement = connection.createStatement();
			// select all persons in table
			ResultSet rs = statement.executeQuery("select * from person");
			// and then show it
			while (rs.next()) {
				System.out.println("name = " + rs.getString("name"));
				System.out.println("id = " + rs.getInt("id"));
			}
		} catch (SQLException e) {
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// step 4: close connection
				System.err.println(e);
			}
		}
	}

}
