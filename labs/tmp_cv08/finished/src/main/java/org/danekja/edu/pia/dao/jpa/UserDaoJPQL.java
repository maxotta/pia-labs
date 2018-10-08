package org.danekja.edu.pia.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.danekja.edu.pia.dao.UserDao;
import org.danekja.edu.pia.domain.User;

/**
 * JPA implementation of the UserDao interface
 *
 * Date: 26.9.15
 *
 * @author Jakub Danek
 */
public class UserDaoJPQL extends GenericDaoJpa<User, Long> implements UserDao {

    /**
     *
     * @param em entity manager to be used by this dao
     */
    public UserDaoJPQL(EntityManager em) {
        super(em, User.class);
    }

    @Override
    public User create(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        TypedQuery<User> q = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
        q.setParameter("username", username);

        try {
            return q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
