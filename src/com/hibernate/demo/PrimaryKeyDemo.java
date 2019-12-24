package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
			
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
		System.out.println("Creating 3 student object...");
		
		Student tempStudent1 = new Student("John", "Doe", "john@test.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@test.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@test.com");
		
		session.beginTransaction();
		
		System.out.println("Saving the students...");
		session.save(tempStudent1);
		session.save(tempStudent2);
		session.save(tempStudent3);
		
		session.getTransaction().commit();
		
		System.out.println("Done!");
		}
		finally {
		factory.close();
		}
	}

}
