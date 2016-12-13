package org.danekja.edu.pia.web.servlet.spring;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.danekja.edu.pia.dao.PostDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Top secret servlet available only to the chosen ones.
 *
 * Date: 26.11.15
 *
 * @author Jakub Danek
 */
@WebServlet("/secret/vip")
public class SecretServlet extends AbstractServlet {

    @Autowired
    private PostDao postDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //for XSS demonstration
        req.setAttribute("post", postDao.getPosts().get(0));

        req.getRequestDispatcher("/WEB-INF/pages/secret.jsp").forward(req, resp);
    }

}
