package org.danekja.edu.pia.util;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;

import org.danekja.edu.pia.dao.GenericDao;
import org.danekja.edu.pia.domain.Address;
import org.danekja.edu.pia.domain.ContactInfo;
import org.danekja.edu.pia.domain.Email;
import org.danekja.edu.pia.domain.Note;
import org.danekja.edu.pia.domain.User;

/**
 * Date: 11.10.15
 *
 * @author Jakub Danek
 */
public class DataGenerator {

    public static void generateData(EntityManager em, GenericDao<User, Long> userDao, GenericDao<ContactInfo, Long> cinfoDao, long count) {

        ContactInfo ci;
        User u;
        em.getTransaction().begin();
        for (int i = 0; i < count; i++) {
            ci = cinfoDao.save(prepareCinfo());
            u = prepareUser(ci);
            userDao.save(u);
        }
        em.getTransaction().commit();

    }

    private static User prepareUser(ContactInfo ci) {
        User u = new User();
        u.setName("Test User");
        u.setCinfo(ci);

        return u;
    }

    private static ContactInfo prepareCinfo() {
        ContactInfo info = new ContactInfo("Contact Information");

        info.setAddresses(new LinkedHashSet<>(prepareAddresses()));
        info.setEmails(new LinkedHashSet<>(prepareEmails()));
        info.setNotes(new LinkedHashSet<>(prepareNotes()));

        return info;
    }

    private static List<Email> prepareEmails() {
        List<Email> emails = new LinkedList<>();

        emails.add(new Email("description1", "email@email.em", prepareNotes()));
        emails.add(new Email("description2", "email@email.em", prepareNotes()));
        emails.add(new Email("description3", "email@email.em", prepareNotes()));

        return emails;
    }

    private static List<Address> prepareAddresses() {
        List<Address> addresses = new LinkedList<>();

        addresses.add(new Address("street1", "city", prepareNotes()));
        addresses.add(new Address("street2", "city", prepareNotes()));

        return addresses;
    }

    private static List<Note> prepareNotes() {
        List<Note> notes = new LinkedList<>();

        notes.add(new Note("Lorem ipsum dolor sit amet Note1"));
        notes.add(new Note("Lorem ipsum dolor sit amet Note2"));
        notes.add(new Note("Lorem ipsum dolor sit amet Note3"));
        notes.add(new Note("Lorem ipsum dolor sit amet Note4"));
        notes.add(new Note("Lorem ipsum dolor sit amet Note5"));

        return notes;
    }
}
