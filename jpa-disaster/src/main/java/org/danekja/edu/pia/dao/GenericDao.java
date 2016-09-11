package org.danekja.edu.pia.dao;

import java.io.Serializable;
import java.util.List;

import org.danekja.edu.pia.domain.BaseEntity;

/**
 * Base interface for DAOs, providing CRUD operations.
 *
 * Date: 26.9.15
 *
 * @author Jakub Danek
 */
public interface GenericDao<E extends BaseEntity<PK>, PK extends Serializable> {

    /**
     * Either inserts new or updates existing instance.
     *
     * @param instance to be persisted
     * @return persisted instance
     */
    E save(E instance);

    /**
     *
     * @param id
     * @return instance with the given id or null if not found
     */
    E findOne(PK id);

    /**
     * Removes the given entity from persistence.
     *
     * @param id if of the entity instance
     */
    void delete(PK id);

    List<E> findAll();

}
