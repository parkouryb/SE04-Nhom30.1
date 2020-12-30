package Interactive;

import Entity.Account;
import Entity.Student;
import Entity.TrainingScores;
import Hibernate.HibernateUtils;
import org.hibernate.Session;

import java.util.List;
import java.util.Set;

public class changeOperation {

    public static boolean changeGPA(String studentId, Float GPA) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            Account account = session.get(Account.class, studentId);
            Student student = account.getInformation();
            // set
            student.setGPA(GPA);

            session.save(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("[ERROR]");
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }

    public static boolean changeEmail(String studentId, String email) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            Student student = session.get(Student.class, studentId);
            // set
            student.setEmail(email);

            session.save(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("[ERROR]");
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }

    public static boolean changeTrainingScores(String studentId, int point, Integer semester, String year) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            Student student = session.get(Student.class, studentId);
            // set
            List<TrainingScores> trainingScores = student.getTrainingScores();

            session.save(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("[ERROR]");
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }

    public static boolean changeTrainingScores(String studentId, int point) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            Student student = session.get(Student.class, studentId);
            List<TrainingScores> trainingScores = student.getTrainingScores();
            // set

            session.save(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("[ERROR]");
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }
}
