package org.danekja.edu.pia;

import org.danekja.edu.pia.dao.jpa.RoleDaoJpa;
import org.danekja.edu.pia.dao.jpa.UserDaoJpa;
import org.danekja.edu.pia.domain.AccountState;
import org.danekja.edu.pia.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App {

    private static final String PERSISTENCE_UNIT = "org.danekja.edu.pia";

    public static void main( String[] args ) {
        //init
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        //Usually this is not how it is done. Application container (such as Spring) creates instances of
        //EntityManager for you. That solves quite a few issues with thread-safety and
        //transaction management, which you would need to take care of yourselves otherwise.
        EntityManager em = factory.createEntityManager();

        JpaExamples examples = new JpaExamples(em, new UserDaoJpa(em), new RoleDaoJpa(em));

        //EXAMPLE 1
        //examples.tryWriteNoFlush(new User("username", "1234", new Date(), AccountState.ACTIVE));

        //EXAMPLE 2
        examples.tryWriteWithFlush(new User("username1", "1234", new Date(), AccountState.ACTIVE), new User("username2", "1234", new Date(), AccountState.ACTIVE));

        //EXAMPLE 3
        //examples.tryUsernameKindaFail();

        //EXAMPLE 4
        //examples.tryUsernameFail();

        //EXAMPLE 5
        //examples.tryUsernameCheck();

        //##############################################################

        //Example 6 (if first run fails with table does not exist error, try running
        //           it again)
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
