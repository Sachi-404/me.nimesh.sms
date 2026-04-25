package me.nimeshdev.ui.student;

import javax.swing.*;
import java.awt.*;

public class StudentAdminPanel extends StudentPanel {

    public StudentAdminPanel() {
        super();

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
