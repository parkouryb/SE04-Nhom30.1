package Server;
import Hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Server {
    public static void main(String[] args) {

        SessionFactory factory = HibernateUtils.getSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            System.out.println("goodbye world!!!?");

            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();

            session.getTransaction().rollback();
        }

        HibernateUtils.shutdown();

    }
}
