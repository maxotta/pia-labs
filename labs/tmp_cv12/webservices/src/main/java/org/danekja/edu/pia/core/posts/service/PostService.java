package org.danekja.edu.pia.core.posts.service;

import java.util.List;

import org.danekja.edu.pia.core.posts.dto.PostDTO;

/**
 * Date: 6.12.16
 *
 * @author Jakub Danek
 */
public interface PostService {

    /**
     * Loads quotes from source, filtered by author's name together with comments attached to the posts.
     * @return list of quotes or empty list
     */
    List<PostDTO> loadPostsWithComments();
}
