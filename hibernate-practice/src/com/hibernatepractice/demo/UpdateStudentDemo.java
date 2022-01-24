package com.hibernatepractice.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatepractice.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		//create session factory
		
		SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
		    int studentId=3;
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id: primary key
			System.out.println("\n Getting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class,studentId);
			System.out.println("Updating student...");
			myStudent.setFirstName("Anushka");
			myStudent.setEmail("Anushka124@gmail.com");
			
			
			//commit the transaction
			
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

		
		
	}

}
