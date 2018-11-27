package org.danekja.edu.pia.web.servlet.spring;

import org.danekja.edu.pia.dao.PostDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

        //output encoding, please note that the encoding should happen in some global fashion, e.g. in filter.
        //req.setAttribute("post", Encode.forHtml(postDao.getPosts().get(0)));

        req.getRequestDispatcher("/WEB-INF/pages/secret.jsp").forward(req, resp);
    }

}
