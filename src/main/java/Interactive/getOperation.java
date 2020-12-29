package Interactive;

import Entity.Event;
import Entity.Student;
import Entity.TrainingScores;
import Hibernate.HibernateUtils;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class getOperation {
    private static <T> List<T> loadAllData(Class<T> type, Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        List<T> data = session.createQuery(criteria).getResultList();
        return data;
    }

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

            result = event.getStudentSet();
        } catch (Exception e) {
            System.err.println("[ERROR]");
            session.getTransaction().rollback();
            return null;
        }
        session.close();
        return result;
    }

    public static Student getStudentByStudentId(String studentId) {
        Student student;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            student = session.get(Student.class, studentId);

        } catch (Exception e) {
            System.err.println("[?]");
            session.getTransaction().rollback();
            session.close();
            return null;
        }
        session.close();
        return student;
    }

    public static List<TrainingScores> getTrainingScoresByStudentId(String studentId) {
        List <TrainingScores> result = new ArrayList<>();
        Student student = getStudentByStudentId(studentId);
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            System.out.println(student);

            result = student.getTrainingScores();

        } catch (Exception e) {
            System.err.println("[ERROR]");
            session.getTransaction().rollback();
            return null;
        }
        session.close();
        return result;
    }

    public static List<Student> getStudentsBySemYear(String sem_year) {
        List <Student> result = new ArrayList<>();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<TrainingScores> cTrainingScores = builder
                    .createQuery(TrainingScores.class);
            cTrainingScores.from(TrainingScores.class);
            List<TrainingScores> trainingScores = session.createQuery(cTrainingScores)
                    .getResultList();
            for (TrainingScores t: trainingScores) {
                if (t.getId().getSem_year().equals(sem_year)) {
                    result.add(t.getId().getStudent());
                }
            }
        } catch (Exception e) {
            System.err.println("[?]");
            session.getTransaction().rollback();
            session.close();
            return null;
        }
        session.close();
        return result;
    }
}
