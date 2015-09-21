package cz.kiv.zcu.pia.core.posts.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import cz.kiv.zcu.pia.core.posts.domain.Post;
import cz.kiv.zcu.pia.core.posts.service.PostServiceClient;
import cz.kiv.zcu.pia.core.posts.service.PostServiceException;
import cz.kiv.zcu.pia.core.posts.service.dto.PostDTO;

/**
 * Implementation of PostManager interface using web service as its source.
 *
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
public class PostManagerImpl implements PostManager {

    private PostServiceClient postServiceClient;

    @Override
    public List<Post> loadPosts(String authorName) throws PostServiceException {
        List<Post> posts = new ArrayList<>();

        //fetch posts from WS and filter out those not matching author's name
        List<PostDTO> fetched = postServiceClient.fetchPosts();
        String author;
        for (PostDTO postDTO : fetched) {
            author = postDTO.getAuthor();       //avoid multiple method calls
            if(authorName == null || authorName.isEmpty() || author.equals(authorName)) {
                posts.add(new Post(postDTO.getId(), postDTO.getText(), author));
            }
        }

        //TASK: posts don't have their comments included, make it happen!

        return posts;
    }

    /*
    DI methods
     */

    @Required
    public void setPostServiceClient(PostServiceClient postServiceClient) {
        this.postServiceClient = postServiceClient;
    }
}
