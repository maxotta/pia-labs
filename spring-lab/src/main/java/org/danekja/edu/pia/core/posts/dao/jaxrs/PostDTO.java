package org.danekja.edu.pia.core.posts.dao.jaxrs;

import org.danekja.edu.pia.core.posts.domain.Post;
import org.danekja.edu.pia.domain.BaseObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DTO for Post entity.
 *
 * Mainly copies structure of {@link Post}, thus
 * only differences are documented here.
 *
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostDTO extends BaseObject {

    @JsonProperty(value = "id")
    private Long id;
    @JsonProperty(value = "content")
    private String text;
    @JsonProperty(value = "createdBy")
    private String author;

    public PostDTO() {
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
        if (!(o instanceof PostDTO)) return false;

        PostDTO postDTO = (PostDTO) o;

        if (author != null ? !author.equals(postDTO.author) : postDTO.author != null) return false;
        if (text != null ? !text.equals(postDTO.text) : postDTO.text != null) return false;

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
        final StringBuilder sb = new StringBuilder("PostDTO{");
        sb.append("id=").append(id);
        sb.append(", text='").append(text).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
