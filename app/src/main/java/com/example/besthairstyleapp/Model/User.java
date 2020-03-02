package com.example.besthairstyleapp.Model;

public class User {
    String user;
    int password;
    String email;
    String accountName;
    int userIcon;

    public User(String user, int password, String email, String accountName, int userIcon) {
        this.user = user;
        this.password = password;
        this.email = email;
        this.accountName = accountName;
        this.userIcon = userIcon;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(int userIcon) {
        this.userIcon = userIcon;
    }

    public void checkPasswordAndEmail(String email,int password){
        if (this.password==password||email.equals(accountName)){

        }else {

        }
    }


}
