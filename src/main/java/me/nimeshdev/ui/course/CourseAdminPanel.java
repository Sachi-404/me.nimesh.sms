package me.nimeshdev.ui.course;

import me.nimeshdev.dto.CourseDTO;
import me.nimeshdev.exception.CourseDataMergeException;

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
            try {
                int effectedId = courseController.handleAddCourse(
                        new CourseDTO(
                                addCourseDialog.getCourseName()
                                , addCourseDialog.getCourseCode()
                        ));
                if (effectedId < 0) throw new CourseDataMergeException("fail to insert new course record", null);

                addCourseDialog.dispose();
                loadTable();
            } catch (Exception ex) {
                addCourseDialog.getInfoLabel().setText(ex.getMessage());
            }
        });
        addCourseDialog.setVisible(true);
    };

    ActionListener handleUpdateButton = event -> {};
}
