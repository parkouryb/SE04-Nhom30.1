package Interactive;

import Hibernate.HibernateUtils;
import org.hibernate.Session;
import Entity.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class DatabaseInteractive {
    private static <T> List<T> loadAllData(Class<T> type, Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        List<T> data = session.createQuery(criteria).getResultList();
        return data;
    }

    public static boolean Register(String command) {
        String[] cmd = command.split(" ");
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            List <User> users = loadAllData(User.class, session);
            User user = new User(cmd[1], cmd[2]);
            System.out.println(user);
            // save new user to database
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("[ERROR]");
//            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        session.close();
        return true;
//        HibernateUtils.shutdown();
    }
}
