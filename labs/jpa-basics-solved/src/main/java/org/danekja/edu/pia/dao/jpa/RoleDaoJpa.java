package org.danekja.edu.pia.dao.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.danekja.edu.pia.dao.RoleDao;
import org.danekja.edu.pia.domain.Role;

/**
 * JPA implementation of the RoleDao interface
 *
 * Date: 26.9.15
 *
 * @author Jakub Danek
 */
public class RoleDaoJpa extends GenericDaoJpa<Role, Long> implements RoleDao {

    /**
     *
     * @param em entity manager to be used by this instance
     */
    public RoleDaoJpa(EntityManager em) {
        super(em, Role.class);
    }

    @Override
    public Set<Role> findByUser(String username) {
        Query q = entityManager.createQuery("SELECT u.roles FROM User u WHERE u.username = :u");
        q.setParameter("u", username);

        return new HashSet<>(q.getResultList());
    }
}
