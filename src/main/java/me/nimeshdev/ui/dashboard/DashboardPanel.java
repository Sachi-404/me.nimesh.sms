package me.nimeshdev.ui.dashboard;

import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {

    public DashboardPanel() {
        setLayout(new GridLayout(2, 2, 20, 20));

        add(createCard("Total Students", "120"));
        add(createCard("Total Courses", "8"));
        add(createCard("Attendance Today", "85%"));
        add(createCard("Results Published", "5"));
    }

    private JPanel createCard(String title, String value) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        JLabel valueLabel = new JLabel(value, SwingConstants.CENTER);

        valueLabel.setFont(new Font("Arial", Font.BOLD, 24));

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(valueLabel, BorderLayout.CENTER);

        return panel;
    }
}
