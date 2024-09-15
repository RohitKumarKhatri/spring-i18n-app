package com.demo.springi18napp.service;

import com.demo.springi18napp.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findUserById(long id);
}
