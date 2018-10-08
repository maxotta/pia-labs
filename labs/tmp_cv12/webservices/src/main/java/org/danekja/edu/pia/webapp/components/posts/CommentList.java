package org.danekja.edu.pia.webapp.components.posts;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.danekja.edu.pia.core.posts.domain.Comment;

/**
 * Component displaying list of Comments
 *
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
public class CommentList extends Panel {

    private final IModel<List<Comment>> comments;

    public CommentList(String id, IModel<List<Comment>> comments) {
        super(id);
        this.comments = comments;
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

        add(new ListView<Comment>("comments", comments) {
            @Override
            protected void populateItem(ListItem<Comment> item) {
                IModel<Comment> model = item.getModel();
                add(new Label("id", new PropertyModel<Long>(model, "id")));
                add(new Label("author", new PropertyModel<Long>(model, "author")));
                add(new Label("text", new PropertyModel<Long>(model, "text")));
            }
        });
    }

}
