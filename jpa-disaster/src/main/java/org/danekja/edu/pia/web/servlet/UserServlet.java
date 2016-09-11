package org.danekja.edu.pia.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.danekja.edu.pia.dao.GenericDao;
import org.danekja.edu.pia.dao.jpa.GenericDaoJpa;
import org.danekja.edu.pia.domain.User;
import org.danekja.edu.pia.util.DbManager;

/**
 * Date: 13.10.15
 *
 * @author Jakub Danek
 */
@WebServlet(value = "/")
public class UserServlet extends HttpServlet {

    private GenericDao<User, Long> userDao;

    public UserServlet() {
        this.userDao = new GenericDaoJpa<User, Long>(DbManager.getEm(), User.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DbManager.getEm().getTransaction().begin();
        List<User> users = userDao.findAll();
        DbManager.getEm().getTransaction().commit();

        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(req, resp);
    }
}
