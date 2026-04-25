package me.nimeshdev.session;

import me.nimeshdev.model.User;

public class SessionManager {

    private static User currentUser;

    public SessionManager() {}

    public static void setCurrentUser(User currentUser) {
        SessionManager.currentUser = currentUser;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void logOut() {
        SessionManager.currentUser = null;
    }
}
