package com.tobiasz.testingservlets.web.routes;

import com.tobiasz.testingservlets.domain.user.UserRole;
import com.tobiasz.testingservlets.web.RootServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends RootServlet {

    @Override
    public void init() throws ServletException {
        this.roleAllowed = UserRole.NO_USER;
        this.title = "Login page";
        this.description = "This is the login page of our routing example";
        this.cacheControl = "max-age=60";
    }

    @Override
    public String loader(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        return "/login";
    }

    @Override
    public String action(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + password);
        return "/login";
    }
}
