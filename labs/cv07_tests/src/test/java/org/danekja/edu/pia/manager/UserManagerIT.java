package org.danekja.edu.pia.manager;

import org.danekja.edu.pia.dao.UserDao;
import org.danekja.edu.pia.domain.User;
import org.danekja.edu.pia.utils.Encoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserManagerIT {

    @Autowired
    private UserManager userManager;
    @Autowired
    private UserDao userDao;
    @Autowired
    private Encoder encoder;

    @Test
    public void testUserRegistration() throws Exception {
        final String username = "Username";
        final String password = "Password";
        User src = new User(username, password);

        userManager.register(src);

        User stored = userDao.findByUsername(username);
        assertNotNull(stored);
        assertEquals(src, stored);
        assertEquals(encoder.encode("Password"), stored.getPassword());
    }
}
