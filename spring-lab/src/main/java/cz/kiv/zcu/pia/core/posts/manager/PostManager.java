package cz.kiv.zcu.pia.core.posts.manager;

import java.util.List;

import cz.kiv.zcu.pia.core.posts.domain.Post;
import cz.kiv.zcu.pia.core.posts.service.PostServiceException;

/**
 * Manager for working with Posts and attached Comments.
 *
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
public interface PostManager {

    /**
     * Loads quotes from source, filtered by author's name.
     * @param authorName desired author's name. If null or empty, all quotes available are returned.
     * @return list of quotes or empty list
     * @throws PostServiceException when connection to the source couldn't have been established
     */
    List<Post> loadPosts(String authorName) throws PostServiceException;
}
