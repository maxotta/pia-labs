package org.danekja.edu.pia.domain;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Date: 6.10.15
 *
 * @author Jakub Danek
 */
@Entity
@Table(name = "danekja_employee")
//@DiscriminatorValue("EMPLOYEE")
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
