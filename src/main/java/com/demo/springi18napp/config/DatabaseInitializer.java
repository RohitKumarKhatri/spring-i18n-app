package com.demo.springi18napp.config;

import com.demo.springi18napp.model.User;
import com.demo.springi18napp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {


    private final UserRepository userRepository;

    public DatabaseInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User(1L, "John Doe", "john@example.com", "en_us", 200D, "11-04-1988", "US"));
        userRepository.save(new User(2L, "Maria Smith", "maria@example.com", "es", 200D, "11-04-1988", "ES"));
        userRepository.save(new User(3L, "Pierre Dupont", "pierre@example.com", "fr", 200D, "11-04-1988", "FR"));
    }
}
