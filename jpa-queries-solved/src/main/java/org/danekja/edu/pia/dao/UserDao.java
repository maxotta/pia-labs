package org.danekja.edu.pia.dao;

import java.util.List;

import org.danekja.edu.pia.domain.User;

/**
 * DAO interface for the User entity
 *
 * Date: 26.9.15
 *
 * @author Jakub Danek
 */
public interface UserDao extends GenericDao<User, String> {

    User create(User user);

    List<User> findByRole(String roleName);

}
