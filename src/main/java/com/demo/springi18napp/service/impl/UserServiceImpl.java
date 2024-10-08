package com.demo.springi18napp.service.impl;

import com.demo.springi18napp.model.User;
import com.demo.springi18napp.repository.UserRepository;
import com.demo.springi18napp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public Optional<User> findUserById(long id) {
        return userRepository.findById(id);
    }
}
