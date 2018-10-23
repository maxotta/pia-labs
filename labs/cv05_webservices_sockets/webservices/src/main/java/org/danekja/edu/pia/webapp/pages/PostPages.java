package org.danekja.edu.pia.webapp.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.ComponentFeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.danekja.edu.pia.core.posts.domain.Post;
import org.danekja.edu.pia.core.posts.manager.PostManager;
import org.danekja.edu.pia.webapp.components.posts.PostView;

import java.util.List;

/**
 * Page displaying list of Quotes.
 *
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
public class PostPages extends WebPage {

    @SpringBean(name = "postManager")
    private PostManager postManager;

    /**
     * Model of the page - displayed posts.
     */
    protected IModel<List<Post>> posts;

    public PostPages() {
        posts = new LoadableDetachableModel<List<Post>>() {
            @Override
            protected List<Post> load() {
                return postManager.loadPostsWithComments();
            }
        };

    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        addComponents();
    }

    /**
     * Adds all visible components to the page
     */
    private void addComponents() {
        //dispaly posts as list
        ListView<Post> view = new ListView<Post>("posts", posts) {
            @Override
            protected void populateItem(ListItem<Post> listItem) {
                listItem.add(new PostView("post", listItem.getModel()));
            }
        };

        add(view);

        //used to display messages
        add(new ComponentFeedbackPanel("feedback", this));
    }
}
