package cz.kiv.zcu.pia.core.posts;

import java.util.ArrayList;
import java.util.List;

import cz.kiv.zcu.pia.core.posts.service.PostServiceClient;
import cz.kiv.zcu.pia.core.posts.service.PostServiceException;
import cz.kiv.zcu.pia.core.posts.service.dto.CommentDTO;
import cz.kiv.zcu.pia.core.posts.service.dto.PostDTO;

/**
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
public class PostServiceClientStub implements PostServiceClient {

    @Override
    public List<PostDTO> fetchPosts() throws PostServiceException {
        List<PostDTO> posts = new ArrayList<>(2);

        PostDTO tmp = new PostDTO();
        tmp.setId(12l);
        tmp.setAuthor("John Doe");
        tmp.setText("I have something important to say.");
        posts.add(tmp);

        tmp = new PostDTO();
        tmp.setId(13l);
        tmp.setAuthor("Carlos");
        tmp.setText("I have something important to say.");
        posts.add(tmp);

        return posts;

    }

    @Override
    public List<CommentDTO> fetchComments() throws PostServiceException {
        return null;
    }
}
