package me.nimeshdev.ui.student;

import me.nimeshdev.exception.StudentDataValidationException;
import me.nimeshdev.model.Student;
import me.nimeshdev.model.embedded.StudentContact;

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

        // Add new student record
        bottomPanel.add(addBtn);
        addBtn.addActionListener(event -> {
            StudentFormDialog addStudentDialog = new StudentFormDialog(null, "Add Student");
            addStudentDialog.getSaveBtn().addActionListener(e -> {

                // call to controller to save data ??????
                try {
                    int addedId = studentController.handleAddStudent(
                            new Student(
                                    addStudentDialog.getFirstName(), addStudentDialog.getLastName()
                                    , new StudentContact(addStudentDialog.getPhone(), addStudentDialog.getEmail())
                            ));

                    if(addedId > -1) addStudentDialog.dispose(); // close dialog box if insertion is success
                } catch (StudentDataValidationException ex) {

                    addStudentDialog.getInfoLabel().setText(ex.getMessage());
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            });
            addStudentDialog.setVisible(true);
        });

        // Update student record
        bottomPanel.add(updateBtn);
        updateBtn.addActionListener(event -> {

            int selectedRow = table.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Select a student first!");
                return;
            }

            // Get user selected id from table row
            int selectedId= Integer.parseInt(table.getValueAt(selectedRow, 0).toString());

            // Call to controller and get student data by selected id
            Student student = new Student();
            student.setContact(new StudentContact(null, null));

            // Open student form dialog
            StudentFormDialog studentUpdateDialog = new StudentFormDialog(null, "Update Student");

            // Load fetch data to form
            studentUpdateDialog.setData(student);

            studentUpdateDialog.getSaveBtn().addActionListener(e -> {

                // Call controller to update record
            });

            studentUpdateDialog.setVisible(true);
        });

        // Delete student record
        bottomPanel.add(deleteBtn);

        add(bottomPanel, BorderLayout.SOUTH);
    }
}
