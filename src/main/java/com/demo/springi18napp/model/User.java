package com.demo.springi18napp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Entity(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String email;
    private String language;
    private double accountBalance;
    private String dateOfBirth;
    private String countryCode;

    public User() {
    }

    public User(long id, String username, String email, String language, double accountBalance, String dateOfBirth, String countryCode) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.language = language;
        this.accountBalance = accountBalance;
        this.dateOfBirth = dateOfBirth;
        this.countryCode = countryCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getLocalDateOfBirth() {
        return LocalDate.parse(this.dateOfBirth,
                DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.of(this.language)));
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Locale getLocale() {
        return Locale.of(this.getLanguage(), this.getCountryCode());
    }
}
