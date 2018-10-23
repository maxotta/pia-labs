package org.danekja.edu.pia.core.posts.dao;

import org.danekja.edu.pia.core.posts.domain.Comment;
import org.danekja.edu.pia.core.posts.domain.Post;

import java.util.List;

/**
 * Web service client for a simple quote source API.
 *
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
public interface PostDao {

    /**
     * Fetches all quotes available
     * @return list of quotes or empty list
     */
    List<Post> findAllPosts();

    /**
     * Fetches all comments available.
     * @return list of comments or empty list
     */
    List<Comment> findAllComments();
}
