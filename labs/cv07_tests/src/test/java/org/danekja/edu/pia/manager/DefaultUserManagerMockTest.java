package org.danekja.edu.pia.manager;

import org.danekja.edu.pia.dao.UserDao;
import org.danekja.edu.pia.domain.User;
import org.danekja.edu.pia.utils.Encoder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DefaultUserManagerMockTest {

    @Mock
    private Encoder encoderStub;
    @Mock
    private UserDao userDaoStub;

    @InjectMocks
    private DefaultUserManager userManager;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUserRegistration() throws Exception {
        final String hashed = "HASHED";
        final String username = "Username";
        final String password = "Password";
        User src = new User(username, password);

        when(userDaoStub.save(src)).thenReturn(src);
        when(userDaoStub.findByUsername(username)).thenReturn(null);
        when(encoderStub.encode(password)).thenReturn(hashed);

        userManager.register(src);

        verify(userDaoStub, times(1)).save(any(User.class));
        verify(userDaoStub, times(1)).findByUsername(username);
        verify(encoderStub, times(1)).encode(password);
        assertEquals(hashed, src.getPassword());
    }
}
