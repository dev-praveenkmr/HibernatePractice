package com.hibernatepractice.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatepractice.demo.entity.Student;

public class DeleteStudentDemo2 {

	public static void main(String[] args) {
		//create session factory
		
		SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
		    int studentId=4;
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id: primary key
			System.out.println("\n Getting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class,studentId);
			System.out.println("Deleting student..." + myStudent);
			session.delete(myStudent);
			
			//delete student id =2
			System.out.println("Deleting studnet id=2");
			session.createQuery("delete from Studnet where id=2").executeUpdate();
			
			//commit the transaction
			
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

		
		
	}

}
