package org.danekja.edu.pia;

import java.util.Date;
import java.util.Set;

import javax.persistence.EntityManager;

import org.danekja.edu.pia.dao.RoleDao;
import org.danekja.edu.pia.dao.UserDao;
import org.danekja.edu.pia.domain.AccountState;
import org.danekja.edu.pia.domain.Address;
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

    /**
     * Persists entity into the persistence context, but doesn't flush.
     *
     * No changes propagated to the db.
     *
     * @param user to be stored
     */
    public void tryWriteNoFlush(User user) {
        userDao.save(user);
    }

    /**
     * Persists two use user instance into the database.
     *
     * @param user1 to be stored
     * @param user2 to be stored
     */
    public void tryWriteWithFlush(User user1, User user2) {
        beginTransaction();
        userDao.save(user1);
        userDao.save(user2);
        commitTransaction();
    }

    /**
     * Attempts to store two different user instances having the same username into the database.
     *
     * What will happen when save done via merge?
     */
    public void tryUsernameKindaFail() {
        User u1 = new User("originalusernamekindafail", "1234", new Date(), AccountState.CREATED);
        User u2 = new User("originalusernamekindafail", "4321", new Date(), AccountState.ACTIVE);

        beginTransaction();
        userDao.save(u1);
        userDao.save(u2);
        commitTransaction();

        //what just happened?
    }

    /**
     * Attempts to store two different user instances having the same username into the database.
     *
     * What will happen when save done via persist?
     */
    public void tryUsernameFail() {
        User u1 = new User("originalusernamefail", "1234", new Date(), AccountState.CREATED);
        User u2 = new User("originalusernamefail", "4321", new Date(), AccountState.ACTIVE);

        beginTransaction();
        userDao.create(u1);
        userDao.create(u2);
        commitTransaction();

        //what just happened?
    }

    /**
     * Attempts to store two different user instances with the same username into the databse.
     *
     * Contains PK check and demonstrates use of transactions.
     */
    public void tryUsernameCheck() {
        User u1 = new User("originalusernamesucc", "1234", new Date(), AccountState.CREATED);
        User u2 = new User("originalusernamesucc", "4321", new Date(), AccountState.ACTIVE);

        beginTransaction();
        try {
            registerUser(u1);
            registerUser(u2);
            commitTransaction();
        } catch (Exception e) {
            rollbackTransaction();
        }
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
     * Demonstrates the issue caused by lazy loading - association is unavailable
     * when the session is closed.
     *
     * @throws org.hibernate.LazyInitializationException
     */
    public void tryLazyFail() {
        beginTransaction();
        User u1 = userDao.findOne("roletestuser");
        rollbackTransaction();

        for (Role r : u1.getRoles()) {
            System.out.println(r.getName());
        }
    }

    /**
     * The LazyInitializationException problem can be solved by writing custom
     * load DAO methods.
     */
    public void tryLazySucc() {
        beginTransaction();
        Set<Role> roles = roleDao.findByUser("roletestuser");
        rollbackTransaction();

        for (Role r : roles) {
            System.out.println(r.getName());
        }

    }

    /**
     * Demonstrates operation cascading on OneToOne association.
     *
     * Run with attached debugger and put breakpoints on specified lines. Watch
     * how database changes during each step.
     */
    public void tryOneToOneCascade() {
        User u = new User("cascadetestuser", "1234", new Date(), AccountState.CREATED);
        Address a = new Address("streename", "city");
        u.setAddress(a);

        beginTransaction();
        userDao.save(u);
        commitTransaction();

        //put breakpoint here and check db
        u.setAddress(null);
        beginTransaction();
        userDao.save(u);
        commitTransaction();

        //put breakpoint here and check db
        u.setAddress(a);
        beginTransaction();
        userDao.save(u);
        commitTransaction();

        //put breakpoint here and check db
        beginTransaction();
        userDao.delete(u.getPK());
        commitTransaction();
    }

    /*
        Auxiliary methods
     */

    /**
     * Saves new user - if the username already exists in the databse, throws exception.
     *
     * @param u to be stored
     * @return persisted user instance
     * @throws Exception thrown when username already taken, NOTE: in real app this should be a specific exception class,
     * not just generic {@link Exception}.
     */
    private User registerUser(User u) throws Exception {
        User test = userDao.findOne(u.getPK());
        if(test != null) {
            throw new Exception("Username already taken!");
        }

        return userDao.save(u);
    }

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
