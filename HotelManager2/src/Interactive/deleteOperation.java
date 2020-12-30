package Interactive;

import Entity.Account;
import Entity.Event;
import Entity.Student;
import Hibernate.HibernateUtils;
import org.hibernate.Session;

import java.util.Set;

public class deleteOperation {
    public static boolean deleteAccount(String studentId) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            Account account = session.get(Account.class, studentId);
            Student student = account.getInformation();

            session.delete(account);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("[ERROR]");
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }

    public static boolean deleteEventbyStudentId(String studentId, Event event) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            Student student = session.get(Student.class, studentId);

            Set<Event> eventSet = student.getEventSet();
            eventSet.remove(event);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("[ERROR]");
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }
}
