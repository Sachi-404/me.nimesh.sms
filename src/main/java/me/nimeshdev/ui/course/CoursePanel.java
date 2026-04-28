package me.nimeshdev.ui.course;

import me.nimeshdev.controller.CourseController;
import me.nimeshdev.dto.CourseDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CoursePanel extends JPanel {

    protected JTable table;
    protected CourseController courseController;


    public CoursePanel() {

        courseController = new CourseController();

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
    }

    protected void loadTable() {

        List<CourseDTO> courses;

        try {
            courses = courseController.handleGetAllCourses();

            String[] columns = {"Subject Id", "Subject Code", "Subject Name"};

            Object[][] data = new Object[courses.size()][columns.length];

            for (int i = 0; i < courses.size(); i++) {
                CourseDTO s = courses.get(i);

                data[i][0] = s.getCourseId();
                data[i][1] = s.getCode();
                data[i][2] = s.getName();
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

