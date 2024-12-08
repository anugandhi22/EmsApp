package com.cjc.emsapp.app.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class JDBCConnectivity {
private static final String DRIVER="com.mysql.cj.jdbc.Driver";
private static final String URL="jdbc:mysql://localhost:3306/emsapp";
private static final String USERNAME="root";
private static final String PASSWORD="root";

public static Connection getConnection() {
	Connection con = null;
	
	try {
		
		Class.forName(DRIVER);
		con = DriverManager.getConnection(URL,USERNAME,PASSWORD);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return con;
}
}
