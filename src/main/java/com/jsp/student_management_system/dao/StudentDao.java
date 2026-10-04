package com.jsp.student_management_system.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.student_management_system.connection.GetConnection;
import com.jsp.student_management_system.entity.Student;

public class StudentDao {
	
	//insert the values in database
	public boolean saveStudent(Student std) {
Connection con=		GetConnection.getConnectionObject();
String insertquery="insert into student values(?,?,?,?)";
     try {
    	PreparedStatement   pstm=con.prepareStatement(insertquery);
    	pstm.setInt(1, std.getId());
    	pstm.setString(2, std.getName());
    	pstm.setInt(3, std.getAge());
    	pstm.setString(4, std.getGender());
    	int row=pstm.executeUpdate();
    	return row>0;
    	
     }catch(SQLException s) {
    	 s.printStackTrace();
     }
     return false;
		
	}
	//delete the records 
	
	public boolean deleteStudent(int id) {
Connection con=GetConnection.getConnectionObject();
String deletequery="delete from student where id=?";
try {
	 PreparedStatement  pstm= con.prepareStatement(deletequery);
	 pstm.setInt(1, id);
	int row= pstm.executeUpdate();
	return row>0;
}catch(SQLException s) {
	s.printStackTrace();
}
return false;

	}
	//fetch element by id
	
	public Student fetchStudentById(int num) {
	Connection	con=GetConnection.getConnectionObject();
	String fetchbyid="select*from student where id=?";
	try {
		
	PreparedStatement  pstm=	con.prepareStatement(fetchbyid);
	   pstm.setInt(1, num);
	ResultSet res=pstm.executeQuery();
if	(res.next()) {
	int id=res.getInt("id");
	String name=res.getString("name");
	int age=res.getInt("age");
	String gender=res.getString("gender");
	
	
	Student std=new Student();
	std.setId(id);
	std.setName(name);
	std.setAge(age);
	std.setGender(gender);
	
	return std;
	
	   
}
	
	}catch(SQLException s) {
		
		s.printStackTrace();
	}
	return null;
		
		
	}
	public List<Student> fetchStudent(){
Connection con=		GetConnection.getConnectionObject();
ArrayList<Student> std=new ArrayList<>();
String fetchstudent="select* from student";
 try {
	   PreparedStatement pstm=con.prepareStatement(fetchstudent);
	   ResultSet result=pstm.executeQuery();
	     while(result.next()) {
	    	  int id=result.getInt("id");
	    	  String name=result.getString("name");
	    	  int age=  result.getInt("age");
	    	  String gender=result.getString("gender");
	    	  //convert data into object
	    	  
	    	  Student student=new Student();
	    	  student.setId(id);
	    	  student.setName(name);
	    	  student.setAge(age);
	    	  student.setGender(gender);
	    	  //add object to the list
	    	    
	    	  std.add(student);
	    	 
	    	 
	    	 
	    	 
	     }
 }catch(SQLException s) {
	 s.printStackTrace();
 }
 return std;

			
	}
	
	public boolean updateStudent(int num,String name) {
Connection  con =GetConnection.getConnectionObject();
String updateQuery="update student set name=? where id=? ";

try {
	 PreparedStatement pstm=    con.prepareStatement(updateQuery);
	 pstm.setString(1, name);
	 pstm.setInt(2, num);
	 int row=pstm.executeUpdate();
	 return row>0;
}catch(SQLException s) {
	s.printStackTrace();
}
return false;
	}
	

}
