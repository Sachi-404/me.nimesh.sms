package me.nimeshdev.ui.student;

import me.nimeshdev.controller.StudentController;
import me.nimeshdev.model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class StudentPanel extends JPanel {

    protected JTable table;

    protected StudentController studentController;

    public StudentPanel() {
        studentController = new StudentController();

        setLayout(new BorderLayout());

        // Top panel (search)
        JPanel topPanel = new JPanel();
        JTextField searchField = new JTextField(20);
        JButton searchBtn = new JButton("Search");

        topPanel.add(new JLabel("Search:"));
        topPanel.add(searchField);
        topPanel.add(searchBtn);

        add(topPanel, BorderLayout.NORTH);

        // Load table
        table = new JTable();
        loadTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Detect row double click
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {

                    int row = table.getSelectedRow();
                    if (row == -1) return;

                    int studentId = (int) table.getValueAt(row, 0);

                    openStudentDetails(studentId);
                }
            }
        });
    }

    private void openStudentDetails(int studentId) {

        StudentDetailsDialog dialog = new StudentDetailsDialog(
                SwingUtilities.getWindowAncestor(this),
                studentId,
                studentController
        );

        dialog.setVisible(true);
    }

    protected void loadTable() {

        List<Student> students;

        try {
            students = studentController.handleAllStudent();

            String[] columns = {"ID", "First Name", "Last Name", "Email", "Phone"};

            Object[][] data = new Object[students.size()][columns.length];

            for (int i = 0; i < students.size(); i++) {
                Student s = students.get(i);

                data[i][0] = s.getStudentId();
                data[i][1] = s.getFirstName();
                data[i][2] = s.getLastName();
                data[i][3] = s.getContact().getEmail();
                data[i][4] = s.getContact().getPhoneNumber();
            }

            table.setModel(new DefaultTableModel(data, columns) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
