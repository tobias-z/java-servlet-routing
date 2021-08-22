package com.tobiasz.testingservlets;

import com.tobiasz.testingservlets.widgets.Navbar;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RootServlet extends HttpServlet implements IRoute {

    protected String title;
    protected String description;
    protected String cacheControl;

    public RootServlet() {
        this.title = "Base title if none was given";
        this.description = "Base title if none was given";
        this.cacheControl = null;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        init();
        String route = loader(req, resp);
        req.setAttribute("title", title);
        req.setAttribute("description", description);
        req.setAttribute("content", "/routes" + route + ".jsp");
        req.setAttribute("navbarItems", new Navbar(req).getMenuItems());
        if (this.cacheControl != null) {
            resp.setHeader("cache-control", this.cacheControl);
        }
        req.getRequestDispatcher("/root.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String redirectPath = action(req, resp);
        resp.sendRedirect(req.getContextPath() + redirectPath);
    }
}
