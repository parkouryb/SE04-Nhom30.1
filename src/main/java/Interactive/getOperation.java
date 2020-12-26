package Interactive;

import Entity.Event;
import Entity.Student;
import Hibernate.HibernateUtils;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Set;

public class getOperation {
    public static Set<Event> getEventsByStudentId(String studentId) {
        Set <Event> result = new HashSet<Event>();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            Student student = session.get(Student.class, studentId);

            result = student.getEventSet();

        } catch (Exception e) {
            System.err.println("[ERROR]");
            session.getTransaction().rollback();
            return null;
        }
        session.close();
        return result;
    }

    public static Set<Student> getStudentByEvent(String eventId) {
        Set <Student> result = new HashSet<Student>();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            Event event = session.get(Event.class, eventId);
            System.out.println("?");
            System.out.println(event);

            result = event.getStudentSet();
        } catch (Exception e) {
            System.err.println("[ERROR]");
            session.getTransaction().rollback();
            return null;
        }
        session.close();
        return result;
    }
}
