package me.nimeshdev.service;

import me.nimeshdev.model.enums.Role;
import me.nimeshdev.ui.admin.SettingsPanel;
import me.nimeshdev.ui.attendance.AttendancePanel;
import me.nimeshdev.ui.course.CourseAdminPanel;
import me.nimeshdev.ui.course.CoursePanel;
import me.nimeshdev.ui.dashboard.DashboardPanel;
import me.nimeshdev.ui.student.StudentAdminPanel;
import me.nimeshdev.ui.student.StudentPanel;

public class NavigationService {


    public static void navigate(Role role) {

        switch (role) {

            case ADMIN :
                loadAdminFrame();
                break;
            case STAFF :
                // staff
                break;
            case STUDENT :
                // student
                loadStudentFrame();
                break;
        }
    }

    private static void loadAdminFrame() {

        new me.nimeshdev.ui.common.MainFrame(
                new DashboardPanel()
                , new StudentAdminPanel()
                , new CourseAdminPanel()
                , new AttendancePanel()
                , new SettingsPanel()
        );
    }

    private static void loadStudentFrame() {

        new me.nimeshdev.ui.common.MainFrame(
                new DashboardPanel()
                , new StudentPanel()
                , new CoursePanel()
                , new AttendancePanel()
                , new SettingsPanel()
        );
    }
}
