package me.nimeshdev.ui.course;

import me.nimeshdev.ui.student.StudentFormDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CourseAdminPanel extends CoursePanel {

    public CourseAdminPanel() {
        super();

        // Bottom panel (buttons)
        JPanel bottomPanel = new JPanel();

        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        // Add new subject record
        bottomPanel.add(addBtn);
        addBtn.addActionListener(handleAddButton);

        // Update subject record
        bottomPanel.add(updateBtn);
        updateBtn.addActionListener(handleUpdateButton);

        // Delete subject record
        bottomPanel.add(deleteBtn);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    ActionListener handleAddButton = event -> {
        CourseFormDialog addCourseDialog = new CourseFormDialog(null, "Add Course");
        addCourseDialog.getSaveBtn().addActionListener(e -> {

            // call to controller to save data ??????
        });
        addCourseDialog.setVisible(true);
    };

    ActionListener handleUpdateButton = event -> {};
}
