package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class ClientTest {

	public static void main(String[] args) {
		

			 //establish connection between java application and database
				Configuration cfg=new Configuration().configure("/hibernate.cfg.xml");
		    //craete session factory object
				SessionFactory factory=cfg.buildSessionFactory();
		    //create session  object
				Session ses=factory.openSession();
		    //creating domain class object
						Student stud=new Student();
		      
		        //set the values
					stud.setSname("Rohit");
						stud.setSemail("Rohit@rk.com");
						stud.setSresult("pass");
						Transaction tx=null;
						try {
		        //begin the transaction
							tx = ses.beginTransaction();
		//save the object
		            int idval=(Integer)ses.save(stud);
							tx.commit();
							System.out.println("\n\t\t Student is saved with ID: "+idval);
						} catch (Exception e) {
							tx.rollback();

						}
		        ses.close();
		        factory.close();

			}//main()
		}//class
						
						
	


