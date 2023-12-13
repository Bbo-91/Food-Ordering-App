package com.example.myapplication.Classes;

public abstract class person {
    private String userName;
    private String password;
    private String email;
    private int id;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public person(String userName, String password, String email){

        this.email = email;
        this.password = password;
        this.userName = userName;
    }


}
