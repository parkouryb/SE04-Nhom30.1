/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.*;
import Hibernate.HibernateUtils;
import Interactive.*;
import org.hibernate.Session;

import java.util.*;
/**
 *
 * @author Cam Nhung
 */
public class AccountServicesImp implements AccountServicesInterface{

    @Override
    public Account authenAccount(String username, String password) {
    	Session session = HibernateUtils.getSessionFactory().getCurrentSession();
    	try {
			session.getTransaction().begin();
			List<Account> accs = getOperation.loadAllData(Account.class, session);
			for (Account account : accs) {
				if (account.getUsername().equals(username) && 
						account.getPassword().equals(password)) {
					System.out.println("tag");
		            return new Account();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	session.close();
        return null;
    }

    @Override
    public void addNew(String username, String password, String fullname) {
        
    }
    
    public static void main(String[] args) {
//        System.out.println("hol");
//    	Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        List<Student> students = new ArrayList<>();
//        try {
//            session.getTransaction().begin();
//            students = getOperation.loadAllData(Student.class, (org.hibernate.Session) session);
//
//        } catch (Exception e) {
//            System.err.println("[ERROR]");
//            session.getTransaction().rollback();
//        }
//        session.close();
//        for(Student student:students) {
//            System.out.println(student);
//        }
    }
}
