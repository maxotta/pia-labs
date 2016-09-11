package org.danekja.edu.pia.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * Date: 11.10.15
 *
 * @author Jakub Danek
 */
@Entity
//@BatchSize(size = 1000) //all entities should have this
public class ContactInfo extends BaseEntity<Long> {

    private String title;

    /*
     *  Better remove this, inverse relations of one-to-one are hard
     *  to make lazy.
     */
    /*private User user;*/

    private Set<Address> addresses;
    private Set<Email> emails;

    private Set<Note> notes;

    public ContactInfo() {
    }

    public ContactInfo(String s) {
        this.title = s;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /*
     *  Better remove this, inverse relations of one-to-one are hard
     *  to make lazy.
     */
/*    @OneToOne(mappedBy = "cinfo")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) //terrible, creates huge cartesian product
    //@Fetch(FetchMode.SUBSELECT) //makes things better by creating lower cartesian product, still terrible, produces a lot of queries
    //@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //final config, lazy is default
    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) //terrible, creates huge cartesian product
    //@Fetch(FetchMode.SUBSELECT) //makes things better by creating lower cartesian product, still terrible, produces a lot of queries
    //@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //final config, lazy is default
    public Set<Email> getEmails() {
        return emails;
    }

    public void setEmails(Set<Email> emails) {
        this.emails = emails;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) //terrible, creates huge cartesian product
    //@Fetch(FetchMode.SUBSELECT) //makes things better by creating lower cartesian product, still terrible, produces a lot of queries
    //@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //final config, lazy is default
    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactInfo)) return false;

        ContactInfo that = (ContactInfo) o;

        return !(title != null ? !title.equals(that.title) : that.title != null);

    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ContactInfo{");
        sb.append("title='").append(title).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
