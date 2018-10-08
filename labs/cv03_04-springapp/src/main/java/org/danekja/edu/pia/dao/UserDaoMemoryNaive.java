package org.danekja.edu.pia.dao;

import org.danekja.edu.pia.domain.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Primary
@Repository("userDaoMemoryNaive")
public class UserDaoMemoryNaive extends GenericDaoMemory<User> implements UserDao {

    @Override
    public User findByUsername(String username) {

        //complexity O(n)
        for (User user : this.cache.values()) {
            if(Objects.equals(username, user.getUsername())) {
                return user;
            }
        }

        return null;
    }
}
