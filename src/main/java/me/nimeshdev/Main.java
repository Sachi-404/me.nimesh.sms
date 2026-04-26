package me.nimeshdev;

import me.nimeshdev.config.HibernateUtil;
import me.nimeshdev.ui.auth.LoginFrame;

public class Main {

    public static void main(String[] args) {

        new HibernateUtil(); // load session factory

        new LoginFrame();

    }
}