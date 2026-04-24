package me.nimeshdev.ui.auth;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

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
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        JButton loginBtn = new JButton("Login");

        panel.add(new JLabel("Username"));
        panel.add(usernameField);
        panel.add(new JLabel("Password"));
        panel.add(passwordField);

        add(panel, BorderLayout.CENTER);
        add(loginBtn, BorderLayout.SOUTH);

        // Action
        loginBtn.addActionListener(e -> login());
    }

    private void login() {
        // For now just navigate
        dispose(); // close login
        new me.nimeshdev.ui.common.MainFrame();
    }
}
