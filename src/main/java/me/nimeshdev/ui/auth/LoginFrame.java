package me.nimeshdev.ui.auth;

import me.nimeshdev.config.HibernateUtil;
import me.nimeshdev.controller.LoginController;
import me.nimeshdev.exception.AuthenticationException;
import me.nimeshdev.model.User;
import me.nimeshdev.service.NavigationService;
import me.nimeshdev.session.SessionManager;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private  JLabel infoLabel;

    public LoginFrame() {
        super();

        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();

        setVisible(true);
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        usernameField = new JTextField();
        passwordField = new JPasswordField();
        infoLabel = new JLabel();

        JButton loginBtn = new JButton("Login");

        panel.add(new JLabel("Username"));
        panel.add(usernameField);
        panel.add(new JLabel("Password"));
        panel.add(passwordField);
        panel.add(infoLabel);

        add(panel, BorderLayout.CENTER);
        add(loginBtn, BorderLayout.SOUTH);

        // Action
        loginBtn.addActionListener(event -> {
            try {
                login();
            }catch (AuthenticationException e) {

                infoLabel.setText(e.getMessage());
            } catch (Exception e) {
                System.out.println(e);
            }
        });
    }

    private void login() throws Exception {

        // just TESTING admin login
        User user = new LoginController().handleLogin(
                    "sachi" //usernameField.getText()
                    , "1234" // new String(passwordField.getPassword())
                );

        if(user != null) {

            // set current login user
            SessionManager.setCurrentUser(user);
            dispose(); // close login

            // load role base navigation
            NavigationService.navigate(SessionManager.getCurrentUser().getRole());

        }
    }
}
