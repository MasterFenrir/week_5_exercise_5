package nl.hanze.funda.admin.logic;

import org.hibernate.Session;

/**
 * Created by Sander on 7-6-2015.
 */
public class UserBroker extends User {

    public UserBroker(Session session) {
        super(session);
    }

}
