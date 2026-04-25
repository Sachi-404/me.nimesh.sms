package me.nimeshdev.ui.student;

import javax.swing.*;
import java.awt.*;

public class StudentPanel extends JPanel {

    protected JTable table;

    public StudentPanel() {
        setLayout(new BorderLayout());

        // Top panel (search)
        JPanel topPanel = new JPanel();
        JTextField searchField = new JTextField(20);
        JButton searchBtn = new JButton("Search");

        topPanel.add(new JLabel("Search:"));
        topPanel.add(searchField);
        topPanel.add(searchBtn);

        add(topPanel, BorderLayout.NORTH);

        // Table
        String[] columns = {"ID", "Full Name", "Date of Birth", "Email", "view"};
        Object[][] data = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};

        table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

    }
}
