package org.danekja.edu.pia.core.utils;

import org.danekja.edu.pia.core.posts.domain.Post;
import org.danekja.edu.pia.core.posts.dto.PostDTO;

import java.util.LinkedList;
import java.util.List;

/**
 * Date: 6.12.16
 *
 * @author Jakub Danek
 */
public class Mapper {

    public static List<PostDTO> map(List<Post> posts) {
        List<PostDTO> toRet = new LinkedList<>();
        for (Post post : posts) {
            toRet.add(new PostDTO(post));
        }

        return toRet;
    }
}
