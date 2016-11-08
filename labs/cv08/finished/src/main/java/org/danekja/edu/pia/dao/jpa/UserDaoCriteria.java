package org.danekja.edu.pia.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.danekja.edu.pia.dao.UserDao;
import org.danekja.edu.pia.domain.User;

/**
 * JPA implementation of the UserDao interface
 *
 * Date: 26.9.15
 *
 * @author Jakub Danek
 */
public class UserDaoCriteria extends GenericDaoJpa<User, Long> implements UserDao {

    /**
     *
     * @param em entity manager to be used by this dao
     */
    public UserDaoCriteria(EntityManager em) {
        super(em, User.class);
    }

    @Override
    public User create(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<User> criteria = cb.createQuery(User.class);
        Root<User> root = criteria.from(User.class);

        Predicate byUsername = cb.equal(root.get("username"), username);
        criteria.where(byUsername);

        TypedQuery<User> q = entityManager.createQuery(criteria);
        try {
            return q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
