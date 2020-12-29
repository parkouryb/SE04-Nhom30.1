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
            session.close();
            return false;
        }
        session.close();
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
            session.close();
            return false;
        }
        session.close();
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
            session.close();
            return false;
        }
        session.close();
        return true;
    }

    public static boolean addSubject(Subject subject) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            session.save(subject);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("[ERROR]");
            session.getTransaction().rollback();
            session.close();
            return false;
        }
        session.close();
        return true;
    }

    public static boolean addTrainingScoresByStudentId(TrainingScores trainingScore) {
        Student student = trainingScore.getId().getStudent();
        System.out.println(student);
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();

            assert student != null;
            student.getTrainingScores().add(trainingScore);
            session.save(trainingScore);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("[ERROR]");
            session.getTransaction().rollback();
            session.close();
            return false;
        }
        session.close();
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
            session.close();
            return false;
        }
        session.close();
        return true;
    }

    public static boolean addSubjectStudent(StudentSubject studentSubject) {
        Student student = studentSubject.getId().getStudent();
        Subject subject = studentSubject.getId().getSubject();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();

            student.getSubjectSet().add(studentSubject);
            subject.getStudentsSet().add(studentSubject);
            session.save(studentSubject);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("[ERROR]");
            session.getTransaction().rollback();
            session.close();
            return false;
        }
        session.close();
        return true;
    }
}
