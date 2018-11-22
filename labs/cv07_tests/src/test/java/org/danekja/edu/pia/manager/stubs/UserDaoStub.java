package org.danekja.edu.pia.manager.stubs;

import org.danekja.edu.pia.dao.UserDao;
import org.danekja.edu.pia.domain.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserDaoStub implements UserDao {

    protected final Map<Long, User> cache;

    public UserDaoStub() {
        this.cache = new HashMap<>();
    }

    @Override
    public User save(User value) {
        return this.cache.put(value.getId(), value);
    }

    @Override
    public User findOne(Long id) {
        return this.cache.get(id);
    }

    @Override
    public void remove(User toRemove) {
        this.cache.remove(toRemove.getId());
    }

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
