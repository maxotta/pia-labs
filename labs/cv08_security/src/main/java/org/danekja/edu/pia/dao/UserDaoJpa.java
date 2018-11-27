package org.danekja.edu.pia.dao;

import org.danekja.edu.pia.domain.User;
import org.danekja.edu.pia.utils.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Date: 26.11.15
 *
 * @author Jakub Danek
 */
@Repository
public class UserDaoJpa extends GenericDaoJpa<User> implements UserDao {

    private Encoder encoder;

    @Autowired
    public UserDaoJpa(Encoder encoder) {
        super(User.class);
        this.encoder = encoder;
    }

    @Override
    public User findByUsername(String username) {
        TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.username = :uname", User.class);
        q.setParameter("uname", username);
        try {
            return q.getSingleResult();
        } catch (NoResultException e) {
            //no result found, ensuring the behaviour described by interface specification
            //see javadoc of the findByUsername method.
            return null;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUsername(username);
    }

    @Override
    public boolean authenticate(final String username, final String password) throws Exception {
        //demonstration of SQL injection
        Connection connection = DriverManager.getConnection("jdbc:mysql://students.kiv.zcu.cz:3306/pia", "pia", "pia");

        //NOTE THAT DUE TO PASSWORD HASHING, THIS CODE WILL NOT ALLOW USER TO LOGIN WITH CORRECT CREDENTIALS.
        //SQL INJECTION WORKS THOUGH, SO USER CAN LOG-IN WITH THAT. GOOD ENOUGH.

        // try using ' OR 1=1--' as pwd  (including the ' characters)
        String sql = "SELECT count(*) FROM " + User.TABLE_NAME + " WHERE `username` = '" + username + "' AND `password` = '" + password + "'";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }
}
