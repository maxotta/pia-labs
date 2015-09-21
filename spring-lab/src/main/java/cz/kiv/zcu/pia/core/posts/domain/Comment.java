package cz.kiv.zcu.pia.core.posts.domain;

import cz.kiv.zcu.pia.domain.BaseObject;

/**
 * Comments users can attach to other items.
 *
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
public class Comment extends BaseObject {

    /**
     * PK
     */
    private Long id;
    /**
     * Text of the comment
     */
    private String text;
    /**
     * Author's name.
     */
    private String author;

    /**
     * Creates empty instance
     */
    public Comment() {
    }

    /**
     * Creates instance without ID.
     *
     * Useful when persisting new Comment from user's input
     *
     * @param text text of the comment
     * @param author name of the author
     */
    public Comment(String text, String author) {
        this.text = text;
        this.author = author;
    }

    /**
     * Useful when creating instances from existing data.
     *
     * @param id    PK
     * @param text text of the comment
     * @param author name of the author
     */
    public Comment(Long id, String text, String author) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;

        Comment comment = (Comment) o;

        if (author != null ? !author.equals(comment.author) : comment.author != null) return false;
        if (text != null ? !text.equals(comment.text) : comment.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Comment{");
        sb.append("id=").append(id);
        sb.append(", text='").append(text).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
