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

        //EXAMPLE 1
        //examples.tryWriteNoFlush(new User("username", "1234", new Date(), AccountState.ACTIVE));

        //EXAMPLE 2
        //examples.tryWriteWithFlush(new User("username1", "1234", new Date(), AccountState.ACTIVE), new User("username2", "1234", new Date(), AccountState.ACTIVE));

        //EXAMPLE 3
        //examples.tryUsernameKindaFail();

        //EXAMPLE 4
        //examples.tryUsernameFail();

        //EXAMPLE 5
        //examples.tryUsernameCheck();

        //##############################################################

        //Example 6
        //examples.tryManyToMany();

        //Example 7
        //examples.tryLazyFail();

        //Example 8
        //examples.tryLazySucc();

        //Example 9
        //this one requires you to put breakpoints inside the method, run it with debugger and check db state in several steps
        //examples.tryOneToOneCascade();


        //finish up
        em.close();
    }

}
