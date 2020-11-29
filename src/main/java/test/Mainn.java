package test;

import Entity.Student;
import Entity.Account;
import Entity.TrainingScores;
import Hibernate.HibernateUtils;
import org.hibernate.Session;

import java.util.Date;

public class Mainn {
    public static void main(String[] args) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();

//        Account hieuAc = new Account("4", "33", "hahieu2k", 0);
//
//        Student hieu = new Student(
//                "4", "Hieu"
//        );
//
//        TrainingScores trainingScores = new TrainingScores("4", 2, "2019-2020", 100);
//
//        hieuAc.setInformation(hieu);
//        session.save(hieuAc);

//        Student a = (Student) session.get(Student.class, "4");
//        a.setTrainingScores(trainingScores);
//        System.out.println(a.getTrainingScores());

//        Account b = (Account) session.get(Account.class, "4");
//        System.out.println(b);
//        System.out.println(b.getInformation());


//        TrainingScores trainingScores = (TrainingScores) session.get(TrainingScores.class, "4");
//
//        System.out.println(trainingScores.getStudent());

        session.getTransaction().commit();

        session.close();
    }
}

