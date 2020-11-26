package test;

import Entity.Student;
import Entity.Account;
import Hibernate.HibernateUtils;
import org.hibernate.Session;

import java.util.Date;

public class Mainn {
    public static void main(String[] args) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Account account = new Account("1", "hahieu2k2", "hahieu2k", 0);
//        Student info = new Student("18001131", "Ha Trung Hieu", "Male"
//                , new Date(), "???", "K63A3", "18001131", "hatrunghieu_t63@hus.edu.vn"
//                , 3.3f);

        Student student = new Student("1", "Joe");
        student.setManager(account);
        account.setInformation(student);

        session.save(student);

//        Student a = (Student) session.get(Student.class, "18001131");
//        System.out.println(a.getManager());

        session.getTransaction().commit();

        session.close();
    }
}

