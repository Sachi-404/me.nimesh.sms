package me.nimeshdev.ui.student;

import me.nimeshdev.controller.StudentController;

import javax.swing.*;
import java.awt.*;

public class AdminStudentDetailsDialog extends StudentDetailsDialog {

    public AdminStudentDetailsDialog(Window parent, int studentId, StudentController controller) {
        super(parent, studentId, controller);
    }

    @Override
    protected void initUI() {
        super.initUI();

        // Bottom Panel (Buttons)
        JPanel buttonPanel = new JPanel();

        JButton enrollBtn = new JButton("Enroll Course");
        JButton removeBtn = new JButton("Remove Course");

        buttonPanel.add(enrollBtn);
        buttonPanel.add(removeBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        // Attach Events
        enrollBtn.addActionListener(e -> openEnrollDialog());
        removeBtn.addActionListener(e -> handleRemoveCourse());
    }

    private void openEnrollDialog() {

        EnrollCourseDialog dialog = new EnrollCourseDialog(
                this,
                studentId,
                controller
        );

        dialog.setVisible(true);

        // refresh after adding
        loadStudentData();
    }

    private void handleRemoveCourse() {

        int row = courseTable.getSelectedRow();
        if (row == -1) return;

        int courseId = (int) courseTable.getValueAt(row, 0);

        // remove

        loadStudentData();
    }


}
