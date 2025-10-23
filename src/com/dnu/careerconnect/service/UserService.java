package com.dnu.careerconnect.service;

import com.dnu.careerconnect.model.User;

public interface UserService {
    User register(User user);
    User findByUsername(String username);
}