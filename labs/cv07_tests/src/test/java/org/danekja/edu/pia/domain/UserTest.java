package org.danekja.edu.pia.domain;


import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testValidate_Ok() {
        User u = new User("username", "password");
        try {
            u.validate();
        } catch (UserValidationException e) {
            fail("Validation should have passed!");
        }
    }

    //the test will fail unless the exception is thrown
    @Test(expected = UserValidationException.class)
    public void testValidate_nullPwd() throws Exception {
        User u = new User("username", null);
        u.validate();
    }

    //the test will fail unless the exception is thrown
    @Test(expected = UserValidationException.class)
    public void testValidate_emptyPwd() throws Exception {
        User u = new User("username", "");
        u.validate();
    }

    //the test will fail unless the exception is thrown
    @Test(expected = UserValidationException.class)
    public void testValidate_noUsername() throws Exception {
        User u = new User(null, "pwd");
        u.validate();
    }

    //the test will fail unless the exception is thrown
    @Test(expected = UserValidationException.class)
    public void testValidate_emptyUsername() throws Exception {
        User u = new User("", "pwd");
        u.validate();
    }

    //the test will fail unless the exception is thrown
    @Test(expected = UserValidationException.class)
    public void testValidate_empty() throws Exception {
        User u = new User("", "");
        u.validate();
    }

    //the test will fail unless the exception is thrown
    @Test(expected = UserValidationException.class)
    public void testValidate_null() throws Exception {
        User u = new User(null, null);
        u.validate();
    }
}
