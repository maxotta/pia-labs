package org.danekja.edu.pia.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.danekja.edu.pia.manager.UserManager;
import org.danekja.edu.pia.web.auth.AuthenticationService;
import org.danekja.edu.pia.web.filter.AuthenticationGuard;
import org.danekja.edu.pia.web.servlet.Login;
import org.danekja.edu.pia.web.servlet.Register;
import org.danekja.edu.pia.web.servlet.SecretServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());

        AuthenticationService auth = ctx.getBean(AuthenticationService.class);

        sce.getServletContext().addServlet("login", new Login(auth)).addMapping("/login");
        sce.getServletContext().addServlet("register", new Register(ctx.getBean(UserManager.class))).addMapping("/register");
        sce.getServletContext().addServlet("secret", new SecretServlet()).addMapping("/secret/vip");

        sce.getServletContext().addFilter("authFilter", new AuthenticationGuard(auth)).addMappingForUrlPatterns(null, false, "/secret/*");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
