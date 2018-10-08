package org.danekja.edu.pia.dao.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.danekja.edu.pia.dao.RoleDao;
import org.danekja.edu.pia.domain.Role;
import org.danekja.edu.pia.domain.User;

/**
 * JPA implementation of the RoleDao interface
 *
 * Date: 26.9.15
 *
 * @author Jakub Danek
 */
public class RoleDaoCriteria extends GenericDaoJpa<Role, Long> implements RoleDao {

    /**
     *
     * @param em entity manager to be used by this instance
     */
    public RoleDaoCriteria(EntityManager em) {
        super(em, Role.class);
    }

    @Override
    public Set<Role> findByUser(String username) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Role> criteria = cb.createQuery(Role.class);
        Root<User> root = criteria.from(User.class);

        //select roles
        criteria.select(root.get("roles"));

        //where user has username
        Predicate byUsername = cb.equal(root.get("username"), username);
        criteria.where(byUsername);

        Query q = entityManager.createQuery(criteria);

        return new HashSet<>(q.getResultList());
    }
}
