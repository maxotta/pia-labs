package org.danekja.edu.pia.domain;

/**
 * Date: 6.10.15
 *
 * @author Jakub Danek
 */
public class Email {

    private String description;
    private String email;

    public Email() {
    }

    public Email(String description, String email) {
        this.description = description;
        this.email = email;
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
}
