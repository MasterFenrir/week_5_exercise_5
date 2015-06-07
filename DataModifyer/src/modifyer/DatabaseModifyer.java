package modifyer;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tables.AccountsEntity;
import tables.MkantoormdwEntity;
import tables.WoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Sander on 2-6-2015.
 */
public class DatabaseModifyer {

    // The session to work with
    private Session session;

    public DatabaseModifyer(Session session) {
        this.session = session;
    }

    /**
     * Set a random broker on each house
     */
    public void setRandomMkantoormdwEntity() {
        ArrayList<Integer> brokerNumbers = getMkantoormdwEntityID();
        List<WoEntity> houses = getWoEntitys();
        Random rand = new Random();

        Transaction tx = session.beginTransaction();

        try {
            houses.forEach(e -> {
                e.setMkmdwid(brokerNumbers.get(rand.nextInt(brokerNumbers.size())));
                session.update(e);
            });
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    /**
     * Move the logindata. Does not work anymore.
     */
    public void moveLoginData() {
        List<MkantoormdwEntity> brokers = getMkantoormdwEntitys();
        Transaction tx = session.beginTransaction();

        try {
            brokers.forEach(e -> {
                AccountsEntity account = new AccountsEntity();
                //account.setUsername(e.getUser());
                //account.setPassword(e.getPwd());
                account.setRights(1);
                session.save(account);
            });
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public void linkLoginData() {
        List<Object[]> accounts = brokerAccounts();
        Transaction tx = session.beginTransaction();

        try {
            accounts.forEach(e -> {
                MkantoormdwEntity broker = (MkantoormdwEntity) e[0];
                AccountsEntity account = (AccountsEntity) e[1];
                broker.setAccountNr(account.getAccountNr());
                session.update(broker);
            });
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    private List<Object[]> brokerAccounts() {
        String hql = "FROM MkantoormdwEntity AS m, AccountsEntity AS a WHERE m.user = a.username";
        Query query = session.createQuery(hql);
        return query.list();
    }

    /**
     * Get a list of numbers from brokers
     *
     * @return A list of broker numbers
     */
    private ArrayList<Integer> getMkantoormdwEntityID() {
        ArrayList<Integer> brokers = new ArrayList<>();
        String hql = "FROM tables.MkantoormdwEntity";
        Query query = session.createQuery(hql);
        List<MkantoormdwEntity> results = query.list();
        results.forEach(e -> brokers.add(e.getMkmdwid()));
        return brokers;
    }

    /**
     * Get a list of houses
     *
     * @return A list of houses
     */
    private List<WoEntity> getWoEntitys() {
        String hql = "FROM tables.WoEntity";
        Query query = session.createQuery(hql);
        return query.list();
    }

    private List<MkantoormdwEntity> getMkantoormdwEntitys() {
        String hql = "FROM tables.MkantoormdwEntity";
        Query query = session.createQuery(hql);
        return query.list();
    }

}
