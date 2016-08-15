package com.blogspot.sontx.tut.dbdemo;

import java.sql.*;

public class DeleteSample {

	public static void main(String[] args) throws ClassNotFoundException {
		// step 1: load driver
		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		try {
			// step 2: create a database connection
			connection = DriverManager.getConnection("jdbc:sqlite:sample.db");

			// step 3: work with your database
			Statement statement = connection.createStatement();
			// rename person who has id is 1 to "tran xuan soan"
			statement.executeUpdate("delete from person where name like '%soan%'");
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
