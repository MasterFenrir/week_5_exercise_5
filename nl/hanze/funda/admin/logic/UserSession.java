package nl.hanze.funda.admin.logic;

import org.hibernate.Query;
import org.hibernate.Session;
import tables.AccountsEntity;

import java.util.List;

/**
 * Created by Sander on 7-6-2015.
 */
public class UserSession {

    private Session session;
    private User user;

    public UserSession(Session session) {
        this.session = session;
    }

    /**
     * Login and get an object representing the user rights
     *
     * @param username The username
     * @param password The password
     * @return The user rights
     * @throws Exception If something goes wrong
     */
    public User login(String username, String password) throws Exception {
        String hql = "FROM AccountsEntity WHERE USERNAME = '" + username + "' AND PASSWORD = '" + password + "'";
        Query query = session.createQuery(hql);
        List<AccountsEntity> list = query.list();
        if (list.size() < 1) throw new Exception("User not found!");
        AccountsEntity account = list.get(0);
        if (account.getRights() == 1) {
            user = new UserBroker(session);
        } else {
            user = new UserAdmin(session);
        }
        return user;
    }

}
