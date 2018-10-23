package org.danekja.edu.pia.core.posts.domain;

import org.danekja.edu.pia.domain.BaseObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Single quote representation.
 *
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
public class Post extends BaseObject {

    /**
     * PK
     */
    private Long id;
    /**
     * Text of the quote
     */
    private String text;
    /**
     * Author of the quote
     */
    private String author;
    /**
     * List of comments attached to the quote.
     */
    private List<Comment> comments = new ArrayList<Comment>();

    /**
     * Creates empty instance
     */
    public Post() {
    }

    /**
     * Useful when creating new instance from user's input.
     * @param text text of the quote
     * @param author author of the quote
     */
    public Post(String text, String author) {
        this.text = text;
        this.author = author;
    }

    /**
     * Useful when creating instances from already persisted data.
     *
     * @param id PK
     * @param text text of the quote
     * @param author author of the quote
     */
    public Post(Long id, String text, String author) {
        this.id = id;
        this.text = text;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @return immutable list of comments; use addComment to add new comments to the list
     */
    public List<Comment> getComments() {
        return Collections.unmodifiableList(comments);
    }

    /**
     * Adds new comment to the list of comments.
     *
     * Duplicates allowed.
     *
     * @param comment comment to be added
     */
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;

        Post post = (Post) o;

        if (author != null ? !author.equals(post.author) : post.author != null) return false;
        if (comments != null ? !comments.equals(post.comments) : post.comments != null) return false;
        if (text != null ? !text.equals(post.text) : post.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Post{");
        sb.append("id=").append(id);
        sb.append(", text='").append(text).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", comments=").append(comments);
        sb.append('}');
        return sb.toString();
    }
}
