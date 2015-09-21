package cz.kiv.zcu.pia.webapp.pages;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.ComponentFeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import cz.kiv.zcu.pia.core.posts.domain.Post;
import cz.kiv.zcu.pia.core.posts.manager.PostManager;
import cz.kiv.zcu.pia.core.posts.service.PostServiceException;
import cz.kiv.zcu.pia.webapp.components.posts.PostView;

/**
 * Page displaying list of Quotes.
 *
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
public class PostPages extends WebPage {

    @SpringBean
    private PostManager postManager;

    /**
     * Model of the page - displayed posts.
     */
    private IModel<List<Post>> posts;

    public PostPages() {
        posts = new ListModel<>();

    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        //initial load of posts on page creation
        try {
            posts.setObject(postManager.loadPosts(null));
        } catch (PostServiceException e) {
            //this is displayed in FeedbackPanel added below
            //other "messaging" methods are e.g. info, success
            //every Wicket Component has them
            this.error("Unable to load posts.");
        }

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
