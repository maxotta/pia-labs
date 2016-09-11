package org.danekja.edu.pia.domain;

/**
 * Date: 11.10.15
 *
 * @author Jakub Danek
 */

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
//@BatchSize(size = 100) //all entities should have this
public class Note extends BaseEntity<Long> {

    private String text;

    public Note() {
    }

    public Note(String s) {
        this.text = s;
    }

    @Column(nullable = false)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note)) return false;

        Note note = (Note) o;

        return !(text != null ? !text.equals(note.text) : note.text != null);

    }

    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Note{");
        sb.append("text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
