package me.nimeshdev.ui.common;

import me.nimeshdev.ui.admin.SettingsPanel;
import me.nimeshdev.ui.attendance.AttendancePanel;
import me.nimeshdev.ui.course.CoursePanel;
import me.nimeshdev.ui.dashboard.DashboardPanel;
import me.nimeshdev.ui.student.StudentPanel;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel contentPanel;

    public MainFrame() {
        super();
        setTitle("Student Management System");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();

        setVisible(true);
    }

    private void initUI() {
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

        contentPanel.add(new DashboardPanel(), "dashboard");
        contentPanel.add(new StudentPanel(), "students");
        contentPanel.add(new CoursePanel(), "courses");
        contentPanel.add(new AttendancePanel(), "attendance");
        contentPanel.add(new SettingsPanel(), "settings");

        add(contentPanel, BorderLayout.CENTER);

        // Navigation
        dashboardBtn.addActionListener(e -> cardLayout.show(contentPanel, "dashboard"));
        studentBtn.addActionListener(e -> cardLayout.show(contentPanel, "students"));
        courseBtn.addActionListener(e -> cardLayout.show(contentPanel, "courses"));
        attendanceBtn.addActionListener(e -> cardLayout.show(contentPanel, "attendance"));
        settingsBtn.addActionListener(e -> cardLayout.show(contentPanel, "settings"));
    }
}
