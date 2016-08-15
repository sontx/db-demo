package com.blogspot.sontx.tut.dbdemo;

import java.sql.*;

public class InsertSample {

	public static void main(String[] args) throws ClassNotFoundException {
		// step 1: load driver
		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		try {
			// step 2: create a database connection
			connection = DriverManager.getConnection("jdbc:sqlite:sample.db");

			// step 3: work with your database
			Statement statement = connection.createStatement();
			statement.executeUpdate("drop table if exists person");
			statement.executeUpdate("create table person (id integer, name string)");
			statement.executeUpdate("insert into person values(1, 'tran xuan son')");
			statement.executeUpdate("insert into person values(2, 'tran xuan soan')");
			statement.executeUpdate("insert into person values(2, 'tran xuan xon')");
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
