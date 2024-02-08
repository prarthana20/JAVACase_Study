package com.hexaware.util;

import java.sql.*;
import java.util.Properties;

public class DatabaseConn {
	
	 public static Connection getConnection() throws SQLException {
	        Properties connectionProps = new Properties();
	        connectionProps.put("user", util.getProperty("db.user"));
	        connectionProps.put("password", util.getProperty("db.password"));

	        String connectionString = "jdbc:mysql://" +
	                util.getProperty("db.host") + ":" +
	                util.getProperty("db.port") + "/" +
	                util.getProperty("db.name");

	        return DriverManager.getConnection(connectionString, connectionProps);
	    }

	public static PreparedStatement prepareStatement(String sql) {
		// TODO Auto-generated method stub
		return null;
	}
	}
