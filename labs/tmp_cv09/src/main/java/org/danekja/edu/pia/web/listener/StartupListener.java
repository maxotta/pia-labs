package org.danekja.edu.pia.web.listener;

import javax.persistence.EntityManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.danekja.edu.pia.dao.GenericDao;
import org.danekja.edu.pia.dao.jpa.GenericDaoJpa;
import org.danekja.edu.pia.domain.ContactInfo;
import org.danekja.edu.pia.domain.User;
import org.danekja.edu.pia.util.DataGenerator;
import org.danekja.edu.pia.util.DbManager;

/**
 * Date: 13.10.15
 *
 * @author Jakub Danek
 */
@WebListener
public class StartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //uncomment this to generate the data for the first time
/*        EntityManager em = DbManager.getEm();

        GenericDao<User, Long> userDao = new GenericDaoJpa<>(em, User.class);
        GenericDao<ContactInfo, Long> cinfoDao = new GenericDaoJpa<>(em, ContactInfo.class);

        DataGenerator.generateData(em, userDao, cinfoDao, Long.parseLong(sce.getServletContext().getInitParameter("data.size")));*/
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DbManager.getEm().close();
    }
}
