package me.nimeshdev.ui.student;

import me.nimeshdev.controller.CourseController;
import me.nimeshdev.controller.StudentController;
import me.nimeshdev.dto.CourseDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class EnrollCourseDialog extends JDialog {

    private JTable table;
    private StudentController controller;
    private CourseController courseController;
    private int studentId;

    public EnrollCourseDialog(Window parent, int studentId, StudentController controller) {
        super(parent, "Enroll Course", ModalityType.APPLICATION_MODAL);

        this.studentId = studentId;
        this.controller = controller;

        initUI();
        loadCourses();

        setSize(400, 300);
        setLocationRelativeTo(parent);
    }

    private void initUI() {

        setLayout(new BorderLayout());

        // Table
        String[] columns = {"ID", "Course Name"};

        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        add(new JScrollPane(table), BorderLayout.CENTER);

        // Bottom Buttons
        JPanel bottomPanel = new JPanel();

        JButton addBtn = new JButton("Enroll");
        JButton cancelBtn = new JButton("Cancel");

        bottomPanel.add(addBtn);
        bottomPanel.add(cancelBtn);

        add(bottomPanel, BorderLayout.SOUTH);

        // Events
        addBtn.addActionListener(e -> handleEnroll());
        cancelBtn.addActionListener(e -> dispose());
    }

    private void loadCourses() {

        courseController = new CourseController();

        List<CourseDTO> courses = null;
        try {
            courses = courseController.handleAllCoursesThatStudentNotRegisterYet(studentId);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        if (courses != null) {
            for (CourseDTO c : courses) {
                model.addRow(new Object[]{
                        c.getCourseId(),
                        c.getName()
                });
            }
        }
    }

    private void handleEnroll() {

        int row = table.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a course");
            return;
        }

        int courseId = (int) table.getValueAt(row, 0);

        try {
//            controller.enrollCourse(studentId, courseId);

            JOptionPane.showMessageDialog(this, "Course enrolled successfully!");
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
