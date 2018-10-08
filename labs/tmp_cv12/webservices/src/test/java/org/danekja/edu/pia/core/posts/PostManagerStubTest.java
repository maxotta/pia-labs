package org.danekja.edu.pia.core.posts;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.danekja.edu.pia.core.BaseTest;
import org.danekja.edu.pia.core.posts.domain.Comment;
import org.danekja.edu.pia.core.posts.domain.Post;
import org.danekja.edu.pia.core.posts.manager.PostManager;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
@Ignore
public class PostManagerStubTest extends BaseTest {

    @Autowired //same as setter injection used in PostManagerImpl class
    @Qualifier("postManagerTestStub") //specifies bean id to inject
    private PostManager postManager;

    /**
     *
     * @throws Exception
     */
    @Test
    public void testListPostsWithComments() throws Exception {
        String authorName = "Carlos";
        List<Post> posts = postManager.loadPostsWithComments();

        //if there are no posts, remaining of this test doesn't make much of a sense, does it?
        assertEquals(2, posts.size());

        Post p = posts.get(0);
        List<Comment> ments = p.getComments();
        assertEquals(2, ments.size());
        for (Comment ment : ments) {
            assertEquals(p.getAuthor(), ment.getAuthor());
        }

        p = posts.get(1);
        ments = p.getComments();
        assertEquals(1, ments.size());
        for (Comment ment : ments) {
            assertEquals(p.getAuthor(), ment.getAuthor());
        }
    }
}
