package org.danekja.edu.pia;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.danekja.edu.pia.dao.jpa.RoleDaoJpa;
import org.danekja.edu.pia.dao.jpa.UserDaoJpa;
import org.danekja.edu.pia.domain.AccountState;
import org.danekja.edu.pia.domain.User;

/**
 * Hello world!
 *
 */
public class App {

    private static final String PERSISTENCE_UNIT = "org.danekja.edu.pia";

    public static void main( String[] args ) {
        //init
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = factory.createEntityManager();

        JpaExamples examples = new JpaExamples(em, new UserDaoJpa(em), new RoleDaoJpa(em));


        examples.tryWriteNoFlush(new User("username", "1234", new Date(), AccountState.ACTIVE));

        //run example methods
        //example methods are designed to be run one at a time, invoking multiple of them
        //in one application run may bring unexpected behaviour

        //check how database changes after each run

        //if special steps need to be taken during the method call (such as debugger breakpoints)
        //it is mention in the method's documentation

        //finish up
        em.close();
    }

}
