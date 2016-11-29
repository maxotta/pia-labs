package org.danekja.edu.pia.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * Date: 29.9.15
 *
 * @author Jakub Danek
 */
@Entity
//@BatchSize(size = 100) //all entities should have this
public class Address extends BaseEntity<Long> {

    private String street;
    private String city;

    private Set<Note> notes;

    public Address() {
    }

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public Address(String street, String city, List<Note> notes) {
        this(street, city);
        this.notes = new HashSet<>(notes);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("street='").append(street).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        return !(city != null ? !city.equals(address.city) : address.city != null);

    }

    @Override
    public int hashCode() {
        int result = street != null ? street.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
