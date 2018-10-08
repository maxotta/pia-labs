package org.danekja.edu.pia.dao.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.danekja.edu.pia.dao.GenericDao;
import org.danekja.edu.pia.domain.BaseEntity;

/**
 * JPA implementation of the GenericDao interface
 *
 * Date: 26.9.15
 *
 * @author Jakub Danek
 */
public class GenericDaoJpa<E extends BaseEntity<PK>, PK extends Serializable> implements GenericDao<E, PK> {

    protected EntityManager entityManager;
    protected Class<E> persistedClass;

    /**
     *
     * @param em entity manager
     * @param persistedClass entity type to be persisted by this instance
     */
    public GenericDaoJpa(EntityManager em, Class<E> persistedClass) {
        this.entityManager = em;
        this.persistedClass = persistedClass;
    }

    @Override
    public E save(E instance) {
        if(instance.getId() == null) {
            entityManager.persist(instance);
            return instance;
        } else {
            return entityManager.merge(instance);
        }
    }

    @Override
    public E findOne(PK id) {
        return entityManager.find(persistedClass, id);
    }

    @Override
    public void delete(PK id) {
        E en = entityManager.find(persistedClass, id);
        if(en != null) {
            entityManager.remove(en);
        }
    }

    @Override
    public List<E> findAll() {
        return entityManager.createQuery("FROM User u JOIN FETCH u.cinfo", persistedClass)
                //.setMaxResults(100) //pagination is useful
                .getResultList();
    }
}
