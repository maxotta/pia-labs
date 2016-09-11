package org.danekja.edu.pia.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Date: 11.10.15
 *
 * @author Jakub Danek
 */
@Entity
public class User extends BaseEntity<Long> {

    private String name;

    private ContactInfo cinfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne
    public ContactInfo getCinfo() {
        return cinfo;
    }

    public void setCinfo(ContactInfo cinfo) {
        this.cinfo = cinfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return !(name != null ? !name.equals(user.name) : user.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
