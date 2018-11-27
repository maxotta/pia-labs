package org.danekja.edu.pia.web.auth;

import org.danekja.edu.pia.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

/**
 * Wrapper around HttpSession providing authentication functionality.
 *
 * NOTE: THIS CLASS IS HERE ONLY FOR PURPOSE OF DEMONSTRATING SQL INJECTION ATTACK.
 * USE STANDARD SPRING SECURITY AUTHENTICATION MECHANISM IN REAL APPLICATIONS!
 *
 * Date: 26.11.15
 *
 * @author Jakub Danek
 */
@Service
public class AuthenticationService {

    private static final String USER = "user";

    private UserManager userManager;

    @Autowired
    public AuthenticationService(UserManager userManager) {
        this.userManager = userManager;
    }

    /**
     * Signs in the user, if username and password match
     *
     * @param session session associated with the request
     * @param username provided username
     * @param password provided password
     * @return true if success, false otherwise
     */
    public boolean authenticate(HttpSession session, String username, String password) throws Exception {
        boolean authenticated = userManager.authenticate(username, password);

        /*
         * NOTE: THIS CLASS IS HERE ONLY FOR PURPOSE OF DEMONSTRATING SQL INJECTION ATTACK.
         * USE STANDARD SPRING SECURITY AUTHENTICATION MECHANISM IN REAL APPLICATIONS!
         */
        if(authenticated) {
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(username, password, Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))));
            session.setAttribute(USER, username);
            return true;
        }

        return false;
    }

    /**
     *
     * @param session session associated with the request
     * @return true if there is a user currently logged in within this session.
     */
    public boolean isLoggedIn(HttpSession session) {
        return session.getAttribute(USER) != null;
    }
}
