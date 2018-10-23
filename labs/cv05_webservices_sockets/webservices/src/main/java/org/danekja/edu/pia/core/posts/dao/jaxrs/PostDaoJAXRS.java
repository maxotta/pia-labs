package org.danekja.edu.pia.core.posts.dao.jaxrs;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.danekja.edu.pia.core.posts.dao.PostDao;
import org.danekja.edu.pia.core.posts.domain.Comment;
import org.danekja.edu.pia.core.posts.domain.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * JAX-RS implementation of PostDao API.
 *
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
public class PostDaoJAXRS implements PostDao {

    private static final Logger logger = LoggerFactory.getLogger(PostDaoJAXRS.class);

    private final WebTarget target;

    public PostDaoJAXRS(String baseUrl) {
        //init target for all invocations with base URL and Jackson (de)serializer
        target = ClientBuilder.newClient()
                .register(JacksonJaxbJsonProvider.class)
                .target(baseUrl);
    }

    @Override
    public List<Post> findAllPosts() {
        Response res = target.path("posts").request(MediaType.APPLICATION_JSON_TYPE).get();

        List<Post> parsed = new ArrayList<>();

        if(res.getStatus() == Response.Status.OK.getStatusCode()) {
            logger.debug("Connection to the posts resource successful!");

            List<PostDTO> posts = res.readEntity(new GenericType<List<PostDTO>>(){});

            for (PostDTO postDTO : posts) {
                parsed.add(new Post(postDTO.getId(), postDTO.getText(), postDTO.getAuthor()));
            }

        } else {
            logger.error("Connection to posts resource failed with response code: {}", res.getStatus());
        }

        return parsed;
    }

    @Override
    public List<Comment> findAllComments() {
        //TASK implement client method for fetching comments
        throw new UnsupportedOperationException();
    }
}
