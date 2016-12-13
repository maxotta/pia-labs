package org.danekja.edu.pia.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.danekja.edu.pia.domain.User;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

/**
 * Date: 26.11.15
 *
 * @author Jakub Danek
 */
@Repository
public class UserDaoJpa extends GenericDaoJpa<User> implements UserDao {

    public UserDaoJpa() {
        super(User.class);
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
        //demonstration of SQL injection, try putting
        Connection connection = DriverManager.getConnection("jdbc:mysql://students.kiv.zcu.cz:3306/pia", "pia", "pia");

        // try using ' OR 1=1--' as pwd  (including the ')
        String sql = "SELECT count(*) FROM danekja_exampleapp_simple_user WHERE `username` = '" + username + "' AND `password` = '" + password + "'";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }
}
