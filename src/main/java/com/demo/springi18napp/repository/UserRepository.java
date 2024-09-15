package com.demo.springi18napp.repository;

import com.demo.springi18napp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}