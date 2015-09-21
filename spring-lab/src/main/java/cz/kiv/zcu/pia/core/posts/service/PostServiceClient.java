package cz.kiv.zcu.pia.core.posts.service;

import java.util.List;

import cz.kiv.zcu.pia.core.posts.service.dto.CommentDTO;
import cz.kiv.zcu.pia.core.posts.service.dto.PostDTO;

/**
 * Web service client for a simple quote source API.
 *
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
public interface PostServiceClient {

    /**
     * Fetches all quotes available.
     * @return list of quotes or empty list
     * @throws PostServiceException if connection fails
     */
    List<PostDTO> fetchPosts() throws PostServiceException;

    /**
     * Fetches all comments available.
     * @return list of comments or empty list
     * @throws PostServiceException if connection fails
     */
    List<CommentDTO> fetchComments() throws PostServiceException;
}
