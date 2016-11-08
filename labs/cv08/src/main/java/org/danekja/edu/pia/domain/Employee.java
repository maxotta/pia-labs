package org.danekja.edu.pia.domain;

import java.util.Date;

import javax.persistence.Entity;

/**
 * Date: 6.10.15
 *
 * @author Jakub Danek
 */
@Entity
public class Employee extends User {

    private String socialSecurityNb;

    public Employee() {
    }

    public Employee(String username, String password, Date dateOfBirth, AccountState state, String socialSecurityNb) {
        super(username, password, dateOfBirth, state);
        this.socialSecurityNb = socialSecurityNb;
    }

    public String getSocialSecurityNb() {
        return socialSecurityNb;
    }

    public void setSocialSecurityNb(String socialSecurityNb) {
        this.socialSecurityNb = socialSecurityNb;
    }
}
