package cz.kiv.zcu.pia.core.posts.service.jaxrs;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import cz.kiv.zcu.pia.core.posts.service.PostServiceClient;
import cz.kiv.zcu.pia.core.posts.service.PostServiceException;
import cz.kiv.zcu.pia.core.posts.service.dto.CommentDTO;
import cz.kiv.zcu.pia.core.posts.service.dto.PostDTO;

/**
 * JAX-RS implementation of PostServiceClient API.
 *
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
public class PostServiceClientJAXRS implements PostServiceClient {

    private final WebTarget target;

    public PostServiceClientJAXRS(String baseUrl) {
        //init target for all invocations with base URL and Jackson (de)serializer
        target = ClientBuilder.newClient()
                .register(JacksonJaxbJsonProvider.class)
                .target(baseUrl);
    }

    @Override
    public List<PostDTO> fetchPosts() throws PostServiceException {
        Response res = target.path("posts").request(MediaType.APPLICATION_JSON_TYPE).get();

        if(res.getStatus() == Response.Status.OK.getStatusCode()) {
            return res.readEntity(new GenericType<List<PostDTO>>(){});
        }


        throw new PostServiceException(res.getStatus());
    }

    @Override
    public List<CommentDTO> fetchComments() throws PostServiceException {
        //TASK implement client method for fetching comments
        throw new UnsupportedOperationException();
    }
}
