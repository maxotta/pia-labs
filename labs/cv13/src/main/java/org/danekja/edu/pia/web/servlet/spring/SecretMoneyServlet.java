package org.danekja.edu.pia.web.servlet.spring;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Top secret servlet available only to the chosen ones.
 *
 * Date: 26.11.15
 *
 * @author Jakub Danek
 */
@WebServlet("/secret/money")
public class SecretMoneyServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().log("POST: If this was a banking application, I just sent money to an account: " + req.getParameter("acc"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().log("GET: If this was a banking application, I just sent money to an account: " + req.getParameter("acc"));
    }
}
