package org.danekja.edu.pia.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.danekja.edu.pia.web.servlet.DIServlet;

/**
 * Application startup listener. Handles registration of servlets
 * and injection of their dependencies.
 *
 * Date: 20.11.15
 *
 * @author Jakub Danek
 */
@WebListener
public class ApplicationStartListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().addServlet("diexample", new DIServlet("Injected at the application start-up")).addMapping("/di");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
