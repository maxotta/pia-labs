package org.danekja.edu.pia.domain;

/**
 * Date: 6.10.15
 *
 * @author Jakub Danek
 */
public class Employee extends User {

    private String socialSecurityNb;

    public String getSocialSecurityNb() {
        return socialSecurityNb;
    }

    public void setSocialSecurityNb(String socialSecurityNb) {
        this.socialSecurityNb = socialSecurityNb;
    }
}
