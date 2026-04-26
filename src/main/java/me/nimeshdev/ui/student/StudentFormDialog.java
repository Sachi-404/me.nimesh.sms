package me.nimeshdev.ui.student;

import me.nimeshdev.model.Student;
import me.nimeshdev.model.embedded.StudentContact;

import javax.swing.*;
import java.awt.*;

public class StudentFormDialog extends JDialog {

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField phoneField;

    private JButton saveBtn;
    private JButton cancelBtn;

    private JLabel infoLabel;

    public StudentFormDialog(Frame parent, String title) {
        super(parent, title, true);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(6, 2, 10, 10));

        // Fields
        add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        add(firstNameField);

        add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        add(lastNameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Phone:"));
        phoneField = new JTextField();
        add(phoneField);

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
    public String getFirstName() { return firstNameField.getText(); }
    public String getLastName() { return lastNameField.getText(); }
    public String getEmail() { return emailField.getText(); }
    public String getPhone() { return phoneField.getText(); }

    public JButton getSaveBtn() { return saveBtn; }

    public void setData(Student student) {
        firstNameField.setText(student.getFirstName());
        lastNameField.setText(student.getLastName());
        emailField.setText(student.getContact().getEmail());
        phoneField.setText(student.getContact().getPhoneNumber());
    }

    public Student loadData(int id) {
        return new Student(
                id
                , getFirstName()
                , getLastName()
                , new StudentContact(getPhone(), getEmail())
        );
    }
}