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

			Student tempStudent1 = new Student("Kevin", "Durant", "kevin@gmail.com");
			Student tempStudent2 = new Student("Klay", "Thompson", "klay@gmail.comm");
			Student tempStudent3 = new Student("Draymond", "Green", "green@gmail.com");

			session.beginTransaction();

			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			session.getTransaction().commit();
			
			System.out.println("Student have been added to the database");
		}
		finally {
			factory.close();
		}
		
		
	}

}
