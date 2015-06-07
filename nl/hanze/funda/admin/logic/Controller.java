package nl.hanze.funda.admin.logic;

import connector.DatabaseConnection;
import nl.hanze.funda.admin.ui.Login;
import org.hibernate.Session;

import java.awt.event.ActionEvent;

/**
 * Created by Sander on 7-6-2015.
 */
public class Controller {

    private Login login;
    private Session session;
    private UserSession userSession;
    private User user;

    public Controller() {
        makeLogin();
    }

    private void makeLogin() {
        login = new Login();
        login.setLoginAction(this::login);
    }

    private void login(ActionEvent actionEvent) {
        try {
            session = DatabaseConnection.getSession();
            userSession = new UserSession(session);
            user = userSession.login(login.getUserName(), login.getPassword());
            login.setVisible(false);
        } catch (Exception e) {
            login.setError(e.getMessage());
        }
    }
}
