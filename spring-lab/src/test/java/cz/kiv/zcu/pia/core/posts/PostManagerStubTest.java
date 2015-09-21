package cz.kiv.zcu.pia.core.posts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cz.kiv.zcu.pia.core.BaseTest;
import cz.kiv.zcu.pia.core.posts.domain.Post;
import cz.kiv.zcu.pia.core.posts.manager.PostManager;

/**
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
public class PostManagerStubTest extends BaseTest {

    @Autowired //same as setter injection used in PostManagerImpl class
    @Qualifier("postManagerTestStub") //specifies bean id to inject
    private PostManager postManager;

    /**
     *
     * @throws Exception
     */
    @Test
    public void testListPostsByName() throws Exception {
        String authorName = "Carlos";
        List<Post> posts = postManager.loadPosts(authorName);

        //if there are no posts, remaining of this test doesn't make much of a sense, does it?
        assertTrue(!posts.isEmpty());

        for (Post post : posts) {
            assertEquals("Expected author's name to be: " + authorName, authorName, post.getAuthor());
        }
    }
}
