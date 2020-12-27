package Interactive;

import Entity.*;
import Hibernate.HibernateUtils;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Set;

public class addOperation {
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

    public static boolean addEvent(Event event) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            session.save(event);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("[ERROR]");
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }

    public static boolean addSubject(Subjects subjects) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            session.save(subjects);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("[ERROR]");
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }

    public static boolean addTrainingScores(String studentId, TrainingScores trainingScore) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            Student student = session.get(Student.class, studentId);

            Set<TrainingScores> trainingScores = student.getTrainingScores();
            trainingScores.add(trainingScore);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("[ERROR]");
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }

    public static boolean addEventStudent(String studentId, Event event) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            Student student = session.get(Student.class, studentId);

            Set <Event> eventSet = student.getEventSet();
            eventSet.add(event);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("[ERROR]");
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }

    public static boolean addSubjectStudent(String studentId, Subjects subjects) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            Student student = session.get(Student.class, studentId);

            Set <Subjects> subjectsSet = student.getSubjectsSet();
            subjectsSet.add(subjects);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("[ERROR]");
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }
}
