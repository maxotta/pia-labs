package org.danekja.edu.pia.core.posts.manager;

import org.danekja.edu.pia.core.posts.dao.PostDao;
import org.danekja.edu.pia.core.posts.domain.Post;

import java.util.List;

/**
 * Implementation of PostManager interface using web service as its source.
 *
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
public class DefaultPostManager implements PostManager {

    private PostDao postDao;

    public DefaultPostManager(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public List<Post> loadPostsWithComments() {
        //fetch posts from WS and filter out those not matching author's name
        List<Post> posts = postDao.findAllPosts();

        //TODO: posts don't have their comments included, make it happen!

        return posts;
    }
}
