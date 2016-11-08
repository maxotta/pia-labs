package org.danekja.edu.pia;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.danekja.edu.pia.dao.RoleDao;
import org.danekja.edu.pia.dao.UserDao;
import org.danekja.edu.pia.domain.AccountState;
import org.danekja.edu.pia.domain.Address;
import org.danekja.edu.pia.domain.Employee;
import org.danekja.edu.pia.domain.Role;
import org.danekja.edu.pia.domain.User;

/**
 * Set of examples demonstrating work with JPA entity manager.
 *
 * Date: 27.9.15
 *
 * @author Jakub Danek
 */
public class JpaExamples {

    private EntityManager em;
    private UserDao userDao;
    private RoleDao roleDao;

    /**
     * Constructor ensuring all mandatory dependencies are satisfied.
     *
     * @param em entity manager instance
     * @param userDao User dao instance
     * @param roleDao Role dao instance
     */
    public JpaExamples(EntityManager em, UserDao userDao, RoleDao roleDao) {
        this.em = em;
        this.userDao = userDao;
        this.roleDao = roleDao;
    }



    /*
    Mapping of collections
     */

    /**
     * Shows how creating new associations work. Same approach would be for
     * the OneToMany association.
     */
    public void tryManyToMany() {
        User u1 = new User("roletestuser", "1234", new Date(), AccountState.CREATED);

        Role r1 = new Role("USER");
        Role r2 = new Role("ADMIN");

        //create role objects
        beginTransaction();
        r1 = roleDao.save(r1);
        r2 = roleDao.save(r2);
        commitTransaction();

        //create new user
        beginTransaction();
        userDao.save(u1);
        commitTransaction();

        //add roles to the user
        beginTransaction();
        u1 = userDao.findOne(u1.getPK());
        u1.getRoles().add(r1);
        u1.getRoles().add(r2);
        userDao.save(u1);
        commitTransaction();


    }

    /**
     * Demonstrates how JPA handles various inheritance mapping strategies.
     *
     * Run 3 times, each time with different strategy set for the User entity.
     *
     */
    public void tryInheritance() {
        Employee e = new Employee("inheritanceuser", "1234", new Date(), AccountState.CREATED, "112233/6655");
        User u = new User("superclassuser", "1234", new Date(), AccountState.CREATED);

        beginTransaction();
        userDao.save(e);
        userDao.save(u);
        commitTransaction();
    }

    /**
     * Demonstrates the issue caused by lazy loading - association is unavailable
     * when the session is closed.
     *
     * @throws org.hibernate.LazyInitializationException
     */
    public void tryLazyFail() {
        //create new data and simulate new request (new EM)
        tryManyToMany();
        em.clear();


        beginTransaction();
        User u1 = userDao.findByUsername("roletestuser");
        rollbackTransaction();
        System.out.println(u1.toString());

        for (Role r : u1.getRoles()) {
            System.out.println(r.getName());
        }
    }

    /**
     * The LazyInitializationException problem can be solved by fetching the entities separately.
     */
    public void tryLazySucc() {
        //create new data and simulate new request (new EM)
        tryManyToMany();
        em.clear();

        beginTransaction();
        Set<Role> roles = roleDao.findByUser("roletestuser");
        rollbackTransaction();

        for (Role r : roles) {
            System.out.println(r.getName());
        }
    }

    /*
        Auxiliary methods
     */


    /**
     * .Starts new transaction
     */
    private void beginTransaction() {
        em.getTransaction().begin();
    }

    /**
     * Commits existing transaction
     */
    private void commitTransaction() {
        em.getTransaction().commit();
    }

    /**
     * Rollbacks existing transaction
     */
    private void rollbackTransaction() {
        em.getTransaction().rollback();
    }

}
