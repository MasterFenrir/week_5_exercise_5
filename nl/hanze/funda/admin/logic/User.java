package nl.hanze.funda.admin.logic;

import org.hibernate.Session;

import java.util.List;

/**
 * Created by Sander on 7-6-2015.
 */
public abstract class User {

    protected Session session;

    public User(Session session) {
        this.session = session;
    }

    public List<Object[]> searchHouse(String houseID) {
        return session.createQuery("FROM WoEntity AS a, SoortwoningEntity AS c, SoortobjectEntity AS d, SoortbouwEntity AS f, StatusEntity AS g, TypewoningEntity AS k " +
                "WHERE woid = " + houseID + " AND a.soortBouw = f.id AND a.soortWoning = c.id AND a.soortObject = d.id AND a.status = g.id AND a.typeWoning = k.id").list();
    }

    public List<Object[]> searchBroker(String brokerID) {
        return session.createQuery("FROM MkantoormdwEntity AS a, AccountsEntity AS b, MkantoorEntity AS c WHERE mkmdwid = " + brokerID +
                " AND a.accountNr = b.accountNr AND a.mkid = c.mkid").list();
    }

}
