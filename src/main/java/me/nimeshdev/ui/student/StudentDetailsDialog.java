package me.nimeshdev.ui.student;

import me.nimeshdev.controller.StudentController;
import me.nimeshdev.dto.CourseDTO;
import me.nimeshdev.dto.StudentDTO;
import me.nimeshdev.model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class StudentDetailsDialog extends JDialog {

    private JTable courseTable;
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel emailLabel;
    private JLabel phoneLabel;
    private StudentController controller;
    private int studentId;


    public StudentDetailsDialog(Window parent, int studentId, StudentController controller) {
        super(parent, "Student Details", ModalityType.APPLICATION_MODAL);

        this.studentId = studentId;
        this.controller = controller;

        initUI();
        loadStudentData();

        setSize(500, 400);
        setLocationRelativeTo(parent);
    }

    private void initUI() {

        setLayout(new BorderLayout());

        // Top Panel (Student Info)
        JPanel infoPanel = new JPanel(new GridLayout(4, 1, 1, 5));

        infoPanel.add(new JLabel("Id:"));
        idLabel = new JLabel();

        infoPanel.add(idLabel);

        infoPanel.add(new JLabel("Name:"));
        nameLabel = new JLabel();

        infoPanel.add(nameLabel);

        infoPanel.add(new JLabel("Email:"));
        emailLabel = new JLabel();

        infoPanel.add(emailLabel);

        infoPanel.add(new JLabel("Phone:"));
        phoneLabel = new JLabel();

        infoPanel.add(phoneLabel);

        add(infoPanel, BorderLayout.NORTH);

        // Center Panel (Courses Table)
        String[] columns = {"Course ID", "Course Code", "Course Name"};

        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        courseTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(courseTable);

        add(scrollPane, BorderLayout.CENTER);

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

    private void loadStudentData() {

        StudentDTO student = null;

        try {
            student = controller.handleStudentWithAllCourses(studentId);

            idLabel.setText(String.valueOf(student.getStudentId()));
            nameLabel.setText(STR."\{student.getFirstName()} \{student.getLastName()}");
            emailLabel.setText(student.getContact().getEmail());
            phoneLabel.setText(student.getContact().getPhoneNumber());
        } catch (Exception e) {
            this.dispose();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        if (student != null)
            if (student.getCourses() != null)
                loadCourses(student.getCourses());
    }

    private void loadCourses(List<CourseDTO> courses) {

        DefaultTableModel model = (DefaultTableModel) courseTable.getModel();

        model.setRowCount(0); // clear old data

        for (CourseDTO c : courses) {
            model.addRow(new Object[]{
                    c.getCourseId(),
                    c.getCode(),
                    c.getName()
            });
        }
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
