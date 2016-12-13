package org.danekja.edu.pia.web.servlet.spring;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Date: 13.12.16
 *
 * @author Jakub Danek
 */
@WebServlet("/route")
public class Route extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String toWhere = req.getParameter("where");
        //unvalidated user input used for redirection -> opens the application to phising!
        resp.sendRedirect(toWhere);
    }
}
