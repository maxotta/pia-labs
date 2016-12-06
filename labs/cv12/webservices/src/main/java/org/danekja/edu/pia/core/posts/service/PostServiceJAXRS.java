package org.danekja.edu.pia.core.posts.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.danekja.edu.pia.core.posts.domain.Post;
import org.danekja.edu.pia.core.posts.dto.PostDTO;
import org.danekja.edu.pia.core.posts.manager.PostManager;
import org.danekja.edu.pia.core.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Date: 6.12.16
 *
 * @author Jakub Danek
 */
@Path("/posts")
@Produces(MediaType.APPLICATION_JSON)
public class PostServiceJAXRS implements PostService {

    private PostManager postManager;

    @Autowired
    public PostServiceJAXRS(PostManager postManager) {
        this.postManager = postManager;
    }

    @GET
    @Override
    public List<PostDTO> loadPostsWithComments() {
        List<Post> posts = postManager.loadPostsWithComments();

        return Mapper.map(posts);
    }
}
