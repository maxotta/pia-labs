package org.danekja.edu.pia.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * Date: 13.12.16
 *
 * @author Jakub Danek
 */
@Repository
public class PostDaoMemory implements PostDao {

    @Override
    public List<String> getPosts() {
        String post = "<script> window.alert(\"You have just been attacked by XSS!\");</script>";
        return Collections.singletonList(post);
    }
}
