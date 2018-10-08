package org.danekja.edu.pia.core.posts;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.danekja.edu.pia.core.BaseTest;
import org.danekja.edu.pia.core.posts.dao.PostDao;
import org.danekja.edu.pia.core.posts.domain.Comment;
import org.danekja.edu.pia.core.posts.domain.Post;
import org.danekja.edu.pia.core.posts.manager.DefaultPostManager;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
@RunWith(MockitoJUnitRunner.class)
@Ignore
public class PostsManagerMockTest extends BaseTest {

    @InjectMocks
    private DefaultPostManager postManager;

    @Mock
    private PostDao postDao;

    /**
     *
     * @throws Exception
     */
    @Test
    public void testListPostsWithComments() throws Exception {
        testListPostsByName_initMockPosts();
        testListPostsByName_initMockComments();

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

    private void testListPostsByName_initMockPosts() {
        List<Post> posts = new ArrayList<>(2);

        Post tmp = new Post();
        tmp.setId(12L);
        tmp.setAuthor("Minsc");
        tmp.setText("What? Boo is outraged! See his fury! It's small, so look close. Trust me, it's there. ");
        posts.add(tmp);

        tmp = new Post();
        tmp.setId(14L);
        tmp.setAuthor("John Doe");
        tmp.setText("I have something important to say.");
        posts.add(tmp);

        given(postDao.findAllPosts()).willReturn(posts);
    }

    private void testListPostsByName_initMockComments() {
        List<Comment> comments = new ArrayList<>(2);

        Comment tmp = new Comment();
        tmp.setId(22L);
        tmp.setPostId(12L);
        tmp.setAuthor("narrator");
        tmp.setText("War... war never changes...");
        comments.add(tmp);

        tmp = new Comment();
        tmp.setId(36L);
        tmp.setPostId(12L);
        tmp.setAuthor("Dr. 0");
        tmp.setText("Today's forecast calls for a 99%chance of clear skies being ruined by artillery fire.");
        comments.add(tmp);

        tmp = new Comment();
        tmp.setId(66L);
        tmp.setPostId(14L);
        tmp.setAuthor("Unknown peon");
        tmp.setText("Work, work.");
        comments.add(tmp);

        tmp = new Comment();
        tmp.setId(92L);
        tmp.setPostId(16L);
        tmp.setAuthor("Grunt");
        tmp.setText("I don't need luck. I have ammo.");
        comments.add(tmp);

        given(postDao.findAllComments()).willReturn(comments);
    }


}
