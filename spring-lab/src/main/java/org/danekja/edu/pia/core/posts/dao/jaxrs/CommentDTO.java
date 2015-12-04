package org.danekja.edu.pia.core.posts.dao.jaxrs;

import org.danekja.edu.pia.core.posts.domain.Comment;
import org.danekja.edu.pia.domain.BaseObject;

/**
 * DTO for Comment entity.
 *
 * Mainly copies structure of {@link Comment}, thus
 * only differences are documented here.
 *
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
public class CommentDTO extends BaseObject {

    private Long id;
    private String text;
    private String author;
    private Long postId;

    public CommentDTO() {
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

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommentDTO)) return false;

        CommentDTO that = (CommentDTO) o;

        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (postId != null ? !postId.equals(that.postId) : that.postId != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (postId != null ? postId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CommentDTO{");
        sb.append("id=").append(id);
        sb.append(", text='").append(text).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", postId=").append(postId);
        sb.append('}');
        return sb.toString();
    }
}
