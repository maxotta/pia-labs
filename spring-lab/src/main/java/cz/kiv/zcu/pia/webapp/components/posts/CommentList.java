package cz.kiv.zcu.pia.webapp.components.posts;

import java.util.List;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

import cz.kiv.zcu.pia.core.posts.domain.Comment;

/**
 * Component displaying list of Comments
 *
 * Date: 11.12.14
 *
 * @author Jakub Danek
 */
public class CommentList extends Panel {

    //TASK implement this component
    //see PostView and PostPages for inspiration

    public CommentList(String id, PropertyModel<List<Comment>> comments) {
        super(id);
    }

}
