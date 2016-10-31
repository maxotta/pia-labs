package org.danekja.edu.pia.domain;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Date: 26.9.15
 *
 * @author Jakub Danek
 */
@Entity
@Table(name="danekja_user")
public class User implements IEntity<String> {

    private String username;
    private String password;
    private Date dateOfBirth;
    private AccountState state;

    private Address address;
    private Email email;

    private Set<Role> roles;

    public User() {
        this.roles = new LinkedHashSet<>();
    }

    public User(String username, String password, Date dateOfBirth, AccountState state) {
        this();
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.state = state;
    }

    @Transient
    @Override
    public String getPK() {
        return getUsername();
    }

    @Id
    @Column(name="username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * ManyToMany association between user and his roles.
     *
     * -- Role may be attached to multiple users, User may have multiple roles
     * thus the ManyToMany
     * @return
     */
    @ManyToMany
    @JoinTable(name = "danekja_user_roles", joinColumns = @JoinColumn(name = "user", referencedColumnName = "username"),
            inverseJoinColumns = @JoinColumn(name= "role", referencedColumnName = "id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
       this.roles = roles;
    }

    /**
     * OneToOne association between user and his address.
     * @return
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Embedded
    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public AccountState getState() {
        return state;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(user.dateOfBirth) : user.dateOfBirth != null) return false;
        return state == user.state;

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", state=").append(state);
        sb.append('}');
        return sb.toString();
    }
}
