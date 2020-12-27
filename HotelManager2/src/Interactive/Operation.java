package Interactive;

import Entity.Account;
import Entity.Student;
import Hibernate.HibernateUtils;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class Operation {
    private static <T> List<T> loadAllData(Class<T> type, Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        List<T> data = session.createQuery(criteria).getResultList();
        return data;
    }

    public static boolean register(Account ac) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            session.save(ac);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("[ERROR]");
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }

    public static boolean addInformation(String studentId, Student student) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            Account account = session.get(Account.class, studentId);
            account.setInformation(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("[ERROR]");
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }


    public static boolean changeInformation(String studentId, Float GPA) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            Account account = session.get(Account.class, studentId);
            Student student = account.getInformation();
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
}
