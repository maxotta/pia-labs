package cz.kiv.zcu.pia.core.posts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import cz.kiv.zcu.pia.core.BaseTest;
import cz.kiv.zcu.pia.core.posts.domain.Post;
import cz.kiv.zcu.pia.core.posts.manager.PostManagerImpl;
import cz.kiv.zcu.pia.core.posts.service.PostServiceClient;
import cz.kiv.zcu.pia.core.posts.service.PostServiceException;
import cz.kiv.zcu.pia.core.posts.service.dto.PostDTO;

/**
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
@RunWith(MockitoJUnitRunner.class)
public class PostsManagerMockTest extends BaseTest {

    @InjectMocks
    private PostManagerImpl postManager;

    @Mock
    private PostServiceClient postServiceClient;

    /**
     *
     * @throws Exception
     */
    @Test
    public void testListPostsByName() throws Exception {
        String authorName = "Carlos";

        testListPostsByName_initMock();

        List<Post> posts = postManager.loadPosts(authorName);

        //if there are no posts, remaining of this test doesn't make much of a sense, does it?
        assertTrue(!posts.isEmpty());

        for (Post post : posts) {
            assertEquals("Expected author's name to be: " + authorName, authorName, post.getAuthor());
        }
    }

    private void testListPostsByName_initMock() throws PostServiceException {
        List<PostDTO> posts = new ArrayList<>(2);

        PostDTO tmp = new PostDTO();
        tmp.setId(12l);
        tmp.setAuthor("John Doe");
        tmp.setText("I have something important to say.");
        posts.add(tmp);

        tmp = new PostDTO();
        tmp.setId(12l);
        tmp.setAuthor("Carlos");
        tmp.setText("I have something important to say.");
        posts.add(tmp);

        given(postServiceClient.fetchPosts()).willReturn(posts);
    }


}
