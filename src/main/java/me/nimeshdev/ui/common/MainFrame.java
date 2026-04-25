package me.nimeshdev.ui.common;

import me.nimeshdev.ui.admin.SettingsPanel;
import me.nimeshdev.ui.attendance.AttendancePanel;
import me.nimeshdev.ui.course.CoursePanel;
import me.nimeshdev.ui.dashboard.DashboardPanel;
import me.nimeshdev.ui.student.StudentPanel;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {

    protected CardLayout cardLayout;
    protected JPanel contentPanel;

    public MainFrame(
            DashboardPanel dashboardPanel
            , StudentPanel studentPanel
            , CoursePanel coursePanel
            , AttendancePanel attendancePanel
            , SettingsPanel settingsPanel
    ) {
        super();
        setTitle("Student Management System");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI(dashboardPanel, studentPanel, coursePanel, attendancePanel, settingsPanel);

        setVisible(true);
    }

    private void initUI(DashboardPanel dashboardPanel, StudentPanel studentPanel, CoursePanel coursePanel, AttendancePanel attendancePanel, SettingsPanel settingsPanel) {
        setLayout(new BorderLayout());

        // Sidebar
        JPanel sidebar = new JPanel(new GridLayout(6, 1));

        JButton dashboardBtn = new JButton("Dashboard");
        JButton studentBtn = new JButton("Students");
        JButton courseBtn = new JButton("Courses");
        JButton attendanceBtn = new JButton("Attendance");
        JButton settingsBtn = new JButton("Settings");

        sidebar.add(dashboardBtn);
        sidebar.add(studentBtn);
        sidebar.add(courseBtn);
        sidebar.add(attendanceBtn);
        sidebar.add(settingsBtn);

        add(sidebar, BorderLayout.WEST);

        // Content panel
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        contentPanel.add(dashboardPanel, "dashboard");
        contentPanel.add(studentPanel, "students");
        contentPanel.add(coursePanel, "courses");
        contentPanel.add(attendancePanel, "attendance");
        contentPanel.add(settingsPanel, "settings");

        add(contentPanel, BorderLayout.CENTER);

        // Navigation
        dashboardBtn.addActionListener(e -> cardLayout.show(contentPanel, "dashboard"));
        studentBtn.addActionListener(e -> cardLayout.show(contentPanel, "students"));
        courseBtn.addActionListener(e -> cardLayout.show(contentPanel, "courses"));
        attendanceBtn.addActionListener(e -> cardLayout.show(contentPanel, "attendance"));
        settingsBtn.addActionListener(e -> cardLayout.show(contentPanel, "settings"));
    }
}
