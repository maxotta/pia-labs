package org.danekja.edu.pia.dao.jpa;

import java.util.Set;

import javax.persistence.EntityManager;

import org.danekja.edu.pia.dao.RoleDao;
import org.danekja.edu.pia.domain.Role;

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
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
