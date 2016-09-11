package org.danekja.edu.pia.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.danekja.edu.pia.dao.UserDao;
import org.danekja.edu.pia.domain.User;

/**
 * JPA implementation of the UserDao interface
 *
 * Date: 26.9.15
 *
 * @author Jakub Danek
 */
public class UserDaoJpa extends GenericDaoJpa<User, String> implements UserDao {

    /**
     *
     * @param em entity manager to be used by this dao
     */
    public UserDaoJpa(EntityManager em) {
        super(em, User.class);
    }

    @Override
    public User create(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User save(User instance) {
        return entityManager.merge(instance);
    }

    @Override
    public List<User> findByRole(String roleName) {
        Query q = entityManager.createQuery("SELECT u FROM User u INNER JOIN u.roles r WHERE r.name = :name");
        q.setParameter("name", roleName);

        return q.getResultList();
    }
}
