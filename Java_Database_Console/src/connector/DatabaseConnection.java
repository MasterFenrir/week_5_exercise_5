package connector;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Sander on 2-6-2015.
 */
public class DatabaseConnection {

    private SessionFactory sessionFactory;

    /**
     * Set up the connection
     *
     * @throws Exception
     */
    public void setUp() throws Exception {
        // A SessionFactory is set up once for an application
        sessionFactory = buildSessionFactory();
    }

    /**
     * Set a random broker on each house
     */
    public void setRandomBroker() {
        ArrayList<Integer> brokerNumbers = getBrokers();
        List<House> houses = getHouses();
        Random rand = new Random();

        Session sess = sessionFactory.openSession();
        Transaction tx = sess.beginTransaction();
        ;
        try {
            houses.forEach(e -> {
                e.setBroker(brokerNumbers.get(rand.nextInt(brokerNumbers.size())));
                sess.update(e);
            });
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            sess.close();
        }

    }

    /**
     * Get a list of numbers from brokers
     *
     * @return A list of broker numbers
     */
    private ArrayList<Integer> getBrokers() {
        ArrayList<Integer> brokers = new ArrayList<>();
        Session session = sessionFactory.openSession();
        String hql = "FROM connector.Broker";
        Query query = session.createQuery(hql);
        List<Broker> results = query.list();
        session.close();
        results.forEach(e -> brokers.add(e.getId()));
        return brokers;
    }

    /**
     * Get a list of houses
     *
     * @return A list of houses
     */
    private List<House> getHouses() {
        Session session = sessionFactory.openSession();
        String hql = "FROM connector.House";
        Query query = session.createQuery(hql);
        List<House> results = query.list();
        session.close();
        return results;
    }

    /**
     * Build a SessionFactory
     *
     * @return A SessionFactory
     */
    private SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        return configuration.buildSessionFactory(new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()).buildServiceRegistry());
    }

    /**
     * Close the database connection
     */
    public void closeConnection() {
        if (sessionFactory != null) sessionFactory.close();
    }

}
