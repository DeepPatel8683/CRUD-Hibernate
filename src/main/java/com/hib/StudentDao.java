package com.hib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class StudentDao {
	
	
private static Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
private static SessionFactory sf = con.buildSessionFactory();

	public static void save(Student e) {
	
			     
	      Session session =sf.openSession();
	      
	      Transaction tf = session.beginTransaction();
	       
	       session.save(e);
	    
	    	
	    	tf.commit();
			
		session.close();
	}
	
	public static List<Student> GetStudentDetail() {
		
		
	      Session session =sf.openSession();
	      
	      Transaction tf = session.beginTransaction();
	      
	      List<Student> st=session.createQuery("from Student").getResultList();
	      
	      tf.commit();	
			session.close();
		return st;
	}
	
	public static void DeleteStudentDetails(String e) {
		
	      Session session =sf.openSession();
	      
	      Transaction tf = session.beginTransaction();
	      Student student = session.get(Student.class,Integer.parseInt(e));
	      session.delete(student);
	      tf.commit();	
			session.close();
			
		
	}
	public static Student getStudentByid(int id) {
		
		 Session session =sf.openSession();
	      
	      Transaction tf = session.beginTransaction();
	      
	      Student student = session.get(Student.class, id);
	      
	      tf.commit();	
			session.close();
			return student;
		
	}

	public static int update(Student e){  
		int status=0;  
		 Session session =sf.openSession();
	      
	      Transaction tf = session.beginTransaction();
	      session.update(e);
	      tf.commit();	
	      session.close();
	      
	      return status;  
	}  
	
}
