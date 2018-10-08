package org.danekja.edu.pia.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * Date: 6.10.15
 *
 * @author Jakub Danek
 */
@Entity
//@BatchSize(size = 100) //all entities should have this
public class Email extends BaseEntity<Long> {

    private String description;
    private String email;

    private Set<Note> notes;

    public Email() {
    }

    public Email(String description, String email) {
        this.description = description;
        this.email = email;
    }

    public Email(String description, String s, List<Note> notes) {
        this(description, s);

        this.notes = new HashSet<>(notes);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) //terrible, creates huge cartesian product
    //@Fetch(FetchMode.SUBSELECT) //makes things better by creating smaller cartesian product, still terrible, produces a lot of queries
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
        if (!(o instanceof Email)) return false;

        Email email1 = (Email) o;

        if (description != null ? !description.equals(email1.description) : email1.description != null) return false;
        return !(email != null ? !email.equals(email1.email) : email1.email != null);

    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Email{");
        sb.append("description='").append(description).append('\'');
        sb.append(", email='").append(email);
        sb.append('}');
        return sb.toString();
    }
}
