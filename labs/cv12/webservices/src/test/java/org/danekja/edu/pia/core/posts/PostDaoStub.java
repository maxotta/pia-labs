package org.danekja.edu.pia.core.posts;

import java.util.ArrayList;
import java.util.List;

import org.danekja.edu.pia.core.posts.dao.PostDao;
import org.danekja.edu.pia.core.posts.domain.Comment;
import org.danekja.edu.pia.core.posts.domain.Post;

/**
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
public class PostDaoStub implements PostDao {

    @Override
    public List<Post> findAllPosts() {
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

        return posts;

    }

    @Override
    public List<Comment> findAllComments() {
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
        tmp.setText("Today's forecast calls for a 99% chance of clear skies being ruined by artillery fire.");
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

        return comments;
    }
}
