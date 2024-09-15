package com.demo.springi18napp.controller;

import com.demo.springi18napp.model.User;
import com.demo.springi18napp.service.UserService;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import static com.demo.springi18napp.util.Commons.*;

@RestController

public class GreetingController {
    private static final String USER_NOT_FOUND_MESSAGE = "User not found";


    private final UserService userService;
    private final MessageSource messageSource;

    public GreetingController(final UserService userService, final MessageSource messageSource) {
        this.userService = userService;
        this.messageSource = messageSource;
    }

    @GetMapping("/greeting/{id}")
    public ModelAndView greeting(@PathVariable Long id) {

        // Find user by ID from the service
        Optional<User> user = userService.findUserById(id);
        ModelAndView modelAndView = new ModelAndView(GREETING_VIEW);

        if (user.isEmpty()) {
            modelAndView.addObject("errorMessage", USER_NOT_FOUND_MESSAGE);
            return modelAndView;
        }

        // add user details
        prepareView(modelAndView, user.get());

        // Render the FreeMarker template
        return modelAndView;  // This will render greeting.ftl
    }

    public void prepareView(ModelAndView modelAndView, User user) {
        // Get greeting message based on the locale
        final String greetingMessage = messageSource.getMessage("greeting", null, user.getLocale());
        modelAndView.addObject("greeting", greetingMessage);
        modelAndView.addObject("userName", user.getUsername());
        modelAndView.addObject("accountBalance", formatCurrencyForLocale(user.getAccountBalance(), user.getLocale()));
        modelAndView.addObject("dateOfBirth", formatDateForLocale(user.getLocalDateOfBirth(), user.getLocale()));
    }
}
