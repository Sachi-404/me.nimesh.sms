package me.nimeshdev.controller;

import me.nimeshdev.model.User;
import me.nimeshdev.service.AuthService;

public class LoginController {

    private final AuthService authService;

    public LoginController() {
        this.authService = new AuthService();
    }

    public User handleLogin(String username, String password) throws Exception {
        return authService.login(username, password);
    }
}
