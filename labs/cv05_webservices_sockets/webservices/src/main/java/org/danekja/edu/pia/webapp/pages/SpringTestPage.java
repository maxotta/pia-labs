package org.danekja.edu.pia.webapp.pages;

import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.danekja.edu.pia.core.posts.domain.Post;
import org.danekja.edu.pia.core.posts.manager.PostManager;

import java.util.List;

public class SpringTestPage extends PostPages {

    @SpringBean(name = "springTestpostManager")
    private PostManager postManager;

    public SpringTestPage() {
        posts = new LoadableDetachableModel<List<Post>>() {
            @Override
            protected List<Post> load() {
                return postManager.loadPostsWithComments();
            }
        };
    }
}
