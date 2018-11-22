package org.danekja.edu.pia.manager;

import org.danekja.edu.pia.dao.UserDao;
import org.danekja.edu.pia.domain.User;
import org.danekja.edu.pia.manager.stubs.EncoderStub;
import org.danekja.edu.pia.manager.stubs.UserDaoStub;
import org.danekja.edu.pia.utils.Encoder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DefaultUserManagerStubTest {

    private Encoder encoderStub;
    private UserDao userDaoStub;

    private UserManager userManager;

    @Before
    public void setUp() throws Exception {
        this.userDaoStub = new UserDaoStub();
        this.encoderStub = new EncoderStub();
        userManager = new DefaultUserManager(userDaoStub, encoderStub);
    }

    @Test
    public void testUserRegistration() throws Exception {
        User src = new User("Username", "Password");

        userManager.register(src);

        User stored = userDaoStub.findByUsername("Username");
        assertNotNull(stored);
        assertEquals(src, stored);
        assertEquals(encoderStub.encode("Password"), stored.getPassword());
    }
}
