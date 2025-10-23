package com.dnu.careerconnect.serviceimpl;

import com.dnu.careerconnect.model.User;
import com.dnu.careerconnect.service.UserService;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserService implements UserService {
    private Map<String, User> byUsername = new HashMap<>();
    private Map<Integer, User> byId = new HashMap<>();
    private int seq = 1;

    @Override
    public User register(User user) {
        user.setId(seq++);
        byUsername.put(user.getUsername(), user);
        byId.put(user.getId(), user);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        return byUsername.get(username);
    }
}