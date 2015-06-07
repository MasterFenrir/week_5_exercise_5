package nl.hanze.funda.admin.ui;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by Sander on 7-6-2015.
 */
public class Login extends JFrame {
    private JPanel MainPane;
    private JPanel CenterPane;
    private JButton loginButton;
    private JTextField username;
    private JPasswordField password;
    private JLabel error;
    private JLabel usernameLable;
    private JLabel passwordLabel;

    public Login() {
        setContentPane(MainPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void setLoginAction(ActionListener e) {
        loginButton.addActionListener(e);
    }

    public String getUserName() {
        return username.getText();
    }

    public String getPassword() {
        return new String(password.getPassword());
    }

    public void setError(String error) {
        this.error.setText(error);
    }
}
