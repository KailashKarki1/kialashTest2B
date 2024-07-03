package com.example.csd214test2bkailash;

public class logintable {
    private String userId;
    public String username;
    private String emailAddress;
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public logintable(String userId, String username, String emailAddress, String password) {
        this.userId = userId;
        this.username = username;
        this.emailAddress = emailAddress;
        this.password = password;
    }
}
