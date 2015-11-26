package org.danekja.edu.pia.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet for dependency injection demonstration.
 *
 * Date: 20.11.15
 *
 * @author Jakub Danek
 */
public class DIServlet extends HttpServlet {

    private String injected;

    public DIServlet(String injected) {
        this.injected = injected;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("text", injected);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
