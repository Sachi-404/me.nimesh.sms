package me.nimeshdev.service;

import me.nimeshdev.dao.UserDAO;
import me.nimeshdev.exception.AuthenticationException;
import me.nimeshdev.model.User;

public class AuthService {

    private final UserDAO userDAO;

    public AuthService()  {
        this.userDAO = new UserDAO();
    }

    public User login(String username, String password) throws Exception {

        User user = userDAO.findUsername(username);

        if(user == null) throw new AuthenticationException("no username matching!");
        else if (password.equals(user.getPassword())) {
            return user;
        }

        throw new AuthenticationException("password is wrong!");
    }
}
