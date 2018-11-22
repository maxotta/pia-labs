package org.danekja.edu.pia.manager;

import org.danekja.edu.pia.dao.UserDao;
import org.danekja.edu.pia.domain.User;
import org.danekja.edu.pia.domain.UserValidationException;
import org.danekja.edu.pia.utils.Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Date: 26.11.15
 *
 * @author Jakub Danek
 */
@Service
public class DefaultUserManager implements UserManager {

    public static final Logger log = LoggerFactory.getLogger(DefaultUserManager.class);

    private UserDao userDao;
    private Encoder encoder;

    @Autowired
    public DefaultUserManager(UserDao userDao, Encoder encoder) {
        this.userDao = userDao;
        this.encoder = encoder;
    }

    @Override
    public boolean authenticate(String username, String password) {
        User u = userDao.findByUsername(username);
        System.out.println(u);
        return u != null && encoder.validate(password, u.getPassword());
    }

    @Override
    public void register(User newUser) throws UserValidationException {

        log.trace("Entering register method with {} as parameter", newUser);

        if(!newUser.isNew()) {
            throw new RuntimeException("User object is not new, use save method for updates!");
        }

        newUser.validate();

        User existinCheck = userDao.findByUsername(newUser.getUsername());
        if(existinCheck != null) {
            throw new UserValidationException("Username already taken!");
        }

        newUser.setPassword(encoder.encode(newUser.getPassword()));

        userDao.save(newUser);
        log.info("New user with username '{}' saved", newUser.getUsername());
    }
}
