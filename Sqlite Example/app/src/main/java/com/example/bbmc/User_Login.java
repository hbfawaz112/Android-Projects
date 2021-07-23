package com.example.bbmc;

public class User_Login {

    private String username;
    private String password;

    public User_Login(String username , String password){
        this.username=username;
        this.password=password;

    }

    @Override
    public String toString() {
        return "User_Login{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
