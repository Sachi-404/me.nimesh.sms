package me.nimeshdev.ui.student;

import javax.swing.*;
import java.awt.*;

public class StudentPanel extends JPanel {

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
        String[] columns = {"ID", "Name", "Email", "Course"};
        Object[][] data = {}; // empty for now

        JTable table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        // Bottom panel (buttons)
        JPanel bottomPanel = new JPanel();

        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        bottomPanel.add(addBtn);
        bottomPanel.add(updateBtn);
        bottomPanel.add(deleteBtn);

        add(bottomPanel, BorderLayout.SOUTH);
    }
}
