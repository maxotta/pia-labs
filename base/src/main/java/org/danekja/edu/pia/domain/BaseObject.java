package org.danekja.edu.pia.domain;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.lang.Long;

/**
 * @author Karel Zíbar
 * @version 1.0
 * @created 20-II-2015 18:10:41
 */
@MappedSuperclass
public class BaseObject implements Serializable {
    protected Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}