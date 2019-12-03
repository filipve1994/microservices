package com.github.filipve1994.msuserservice.services;

import com.github.filipve1994.msuserservice.models.User;

import java.util.List;

public interface UserService {

    User registerUser(User input);

    List<User> findAll();
}
