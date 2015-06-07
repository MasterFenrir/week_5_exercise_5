package nl.hanze.funda.admin.logic;

import org.hibernate.Session;

/**
 * Created by Sander on 7-6-2015.
 */
public class UserAdmin extends User {

    public UserAdmin(Session session) {
        super(session);
    }

}
