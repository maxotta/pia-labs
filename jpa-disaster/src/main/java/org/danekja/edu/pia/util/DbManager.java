package org.danekja.edu.pia.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Date: 13.10.15
 *
 * @author Jakub Danek
 */
public class DbManager {

    private static final String PERSISTENCE_UNIT = "org.danekja.edu.pia";

    private static EntityManager em;

    public static EntityManager getEm() {
        if(em == null) {
            em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
        }

        return em;
    }
}
