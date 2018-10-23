package org.danekja.edu.pia.webapp.components.posts;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.danekja.edu.pia.core.posts.domain.Comment;
import org.danekja.edu.pia.core.posts.domain.Post;

import java.util.List;

/**
 * Component displaying single Post
 *
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
public class PostView extends Panel {

    /**
     * Model of the post to be dispalyed.
     *
     * Always use Models to reference data objects.
     *
     * Reasons e.g. here: http://wicket.apache.org/guide/guide/modelsforms.html#modelsforms_8
     *
     */
    private final IModel<Post> post;

    /**
     * Initializes view component for displaying a single Post.
     *
     *
     * @param id component id
     * @param post non-null model with Post instance
     */
    public PostView(String id, IModel<Post> post) {
        super(id);
        this.post = post;


    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        addComponents();
    }

    /**
     * Adds all visible components to the panel
     */
    private void addComponents() {
        add(new Label("id", new PropertyModel<Long>(post, "id")));
        add(new Label("author", new PropertyModel<Long>(post, "author")));
        add(new Label("text", new PropertyModel<Long>(post, "text")));

        add(new CommentList("comments", new PropertyModel<List<Comment>>(post, "comments")));
    }
}
