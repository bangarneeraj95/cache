package com.cache;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.property.Getter;
import org.hibernate.sql.Select;
import org.hibernate.SessionFactory;

public class StudentLogic {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Object o = session.load(Student.class, new Integer(102));

		Student st = (Student) o;
		System.out.println("Loaded object studenst name is___"
				+ st.getStudent_name());
		System.out.println("Object Loaded successfully.....!!");

		Student s = new Student();
		s.setStudent_name("nrj");
		s.setStudent_id(117);
		s.setStudent_course("BE");
		session.save(s);
		System.out.println("student id:" + s.getStudent_id());
		System.out.println("student name:" + s.getStudent_name());
		System.out.println("student course:" + s.getStudent_course());
		tx.commit();
		session.close();
		System.out.println("saved successfully!");

		Student s2 = new Student();
		Session session2 = factory.openSession();
		Transaction t = session2.beginTransaction();
		/*s2.setStudent_id(207);
		s2.setStudent_course("be");
		s2.setStudent_name("xyz");
		session2.persist(s2);

		System.out.println("student id:" + s2.getStudent_id());
		System.out.println("student name:" + s2.getStudent_name());
		System.out.println("student course:" + s2.getStudent_course());

		t.commit();
		session2.close();
		System.out.println(" session2 saved successfully!");*/

		factory.close();
	}
}
