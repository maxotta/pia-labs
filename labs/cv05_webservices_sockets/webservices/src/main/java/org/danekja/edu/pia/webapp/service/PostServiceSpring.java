package org.danekja.edu.pia.webapp.service;

import org.danekja.edu.pia.core.posts.domain.Post;
import org.danekja.edu.pia.core.posts.dto.PostDTO;
import org.danekja.edu.pia.core.posts.manager.PostManager;
import org.danekja.edu.pia.core.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostServiceSpring implements PostService {

    private PostManager postManager;

    @Autowired
    public PostServiceSpring(PostManager postManager) {
        this.postManager = postManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    @Override
    public List<PostDTO> loadPostsWithComments() {
        List<Post> posts = postManager.loadPostsWithComments();

        return Mapper.map(posts);
    }
}
