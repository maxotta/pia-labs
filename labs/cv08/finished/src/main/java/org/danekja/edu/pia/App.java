package org.danekja.edu.pia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.danekja.edu.pia.dao.jpa.RoleDaoCriteria;
import org.danekja.edu.pia.dao.jpa.RoleDaoJPQL;
import org.danekja.edu.pia.dao.jpa.UserDaoCriteria;
import org.danekja.edu.pia.dao.jpa.UserDaoJPQL;

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

        JpaExamples examples = new JpaExamples(em, new UserDaoJPQL(em), new RoleDaoJPQL(em));
        JpaExamples examples2 = new JpaExamples(em, new UserDaoCriteria(em), new RoleDaoCriteria(em));

        //Example 1
        //examples.tryManyToMany();

        //Example 2
        //examples.tryInheritance();


        //---------------------------------------
        //Example 3
        //examples.tryLazyFail();
        //Example 4
        //examples2.tryLazyFail();

        //Example 5
        //examples.tryLazySucc();
        //Example 6
        //examples2.tryLazySucc();


        //finish up
        em.close();
    }

}
