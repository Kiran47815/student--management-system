package com.jsp.student_management_system.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
 
public static  Connection getConnectionObject() {	
	String url="jdbc:postgresql://localhost:5432/student-db";
	String user="postgres";
	String pwd="test";
	
	  try {
		Class.forName("org.postgresql.Driver");
Connection	con=	DriverManager.getConnection(url, user,pwd);
return con;
	  } catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	  }catch(SQLException s) {
		  s.printStackTrace();
	  }
	  return null;
}


}
