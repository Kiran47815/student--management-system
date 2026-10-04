package com.jsp.student_management_system.controller;

import java.util.List;
import java.util.Scanner;

import com.jsp.student_management_system.dao.StudentDao;
import com.jsp.student_management_system.entity.Student;

public class StudentController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentDao dao = new StudentDao();
		while (true) {
			System.out.println("1.insert the records");

			System.out.println("2.delete the record");
			System.out.println("3.fetch records by id");
			System.out.println("4.get all the records");
			System.out.println("5.upadte the records");
			System.out.println("6.exit fromm the application");
	        System.out.println("enter the choice");
			int choice = sc.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("enter the id");
				int id = sc.nextInt();
				System.out.println("enter the name");
				String name = sc.next();
				System.out.println("enter the age");
				int age = sc.nextInt();
				System.out.println("enter the gender");
				String gender = sc.next();

				// covert the data into object
				Student std = new Student();
				std.setId(id);
				std.setName(name);
				std.setAge(age);
				std.setGender(gender);
				// call save student
				boolean b = dao.saveStudent(std);
				if (b) {
					System.out.println("insert the record");
				} else {
					System.out.println("not inserted");
				}

				break;
			}
			case 2: {
				System.out.println("enter the empid");
				int id = sc.nextInt();
				boolean b = dao.deleteStudent(id);
				if (b) {
					System.out.println("delete the record");
				} else {
					System.out.println("not delete the records");
				}
				break;

			}

			case 3: {
				System.out.println("enter the id");
				int id = sc.nextInt();
				Student std = dao.fetchStudentById(id);
				if (std != null) {
					System.out.println("student Id "+std.getId());
					System.out.println("Student name "+std.getName());
					System.out.println("student age "+std.getAge());
					System.out.println("student gender "+std.getGender());

					System.out.println("---------------------------------");

				} else {
					System.out.println("not found");
				}
				break;

			}
			case 4: {
				List<Student> std = dao.fetchStudent();
				for (Student student : std) {
					System.out.println("student Id "+student.getId());
					System.out.println("student name "+student.getName());
					System.out.println("student age "+student.getAge());
					System.out.println("student gender "+student.getGender());

					System.out.println("----------------------------");

				}
				break;
			}
			case 5: {
				System.out.println("enter the id");
				int id = sc.nextInt();
				System.out.println("enter the name");
				String name = sc.next();
				boolean b = dao.updateStudent(id, name);
				if (b) {
					System.out.println("updated");
				} else {
					System.out.println("not updated");
				}
				break;
			}
			default: {
				System.err.println("invalid input");
			}
			case 6: {
				System.out.println("you can exit from the application");
				System.exit(0);
			}

			}
		}
	}

}
