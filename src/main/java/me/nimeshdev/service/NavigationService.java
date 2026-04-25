package me.nimeshdev.service;

import me.nimeshdev.model.enums.Role;

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
                break;
        }
    }

    private static void loadAdminFrame() {

        new me.nimeshdev.ui.common.MainFrame();
    }
}
