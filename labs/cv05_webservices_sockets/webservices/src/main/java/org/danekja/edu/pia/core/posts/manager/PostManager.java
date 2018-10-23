package org.danekja.edu.pia.core.posts.manager;

import org.danekja.edu.pia.core.posts.domain.Post;

import java.util.List;

/**
 * Manager for working with Posts and attached Comments.
 *
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
public interface PostManager {

    /**
     * Loads quotes from source, filtered by author's name together with comments attached to the posts.
     * @return list of quotes or empty list
     */
    List<Post> loadPostsWithComments();
}
