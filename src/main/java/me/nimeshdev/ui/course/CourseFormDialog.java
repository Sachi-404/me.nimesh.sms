package me.nimeshdev.ui.course;

import me.nimeshdev.model.Course;

import javax.swing.*;
import java.awt.*;

public class CourseFormDialog extends JDialog {

    private JTextField courseCode;
    private JTextField courseName;

    private JButton saveBtn;
    private JButton cancelBtn;

    private JLabel infoLabel;

    public CourseFormDialog(Frame parent, String title) {
        super(parent, title, true);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(6, 2, 10, 10));

        // Fields
        add(new JLabel("Course Code:"));
        courseCode = new JTextField();
        add(courseCode);

        add(new JLabel("Course Name:"));
        courseName = new JTextField();
        add(courseName);


        add(new JLabel(""));
        infoLabel = new JLabel("");
        add(infoLabel);

        // Buttons
        saveBtn = new JButton("Save");
        cancelBtn = new JButton("Cancel");

        add(saveBtn);
        add(cancelBtn);

        cancelBtn.addActionListener(e -> dispose());
    }

    public JLabel getInfoLabel() {
        return infoLabel;
    }
    public String getCourseCode() { return courseCode.getText(); }
    public String getCourseName() { return courseName.getText(); }

    public JButton getSaveBtn() { return saveBtn; }

    public void setData(Course course) {
        courseCode.setText(course.getCode());
        courseName.setText(course.getName());
    }

    public Course loadData(int id) {
        return new Course(
                id
                , getCourseCode()
                , getName()
        );
    }
}