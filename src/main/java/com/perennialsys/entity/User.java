package com.perennialsys.entity;

public class User {
    private int userId;
    private int id;
    private String title;
    private String completed;
    public User(){

    }

    public User(int userId, int id, String title, String completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public int getUserId() {
        return userId;
    }

    public User setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public User setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCompleted() {
        return completed;
    }

    public User setCompleted(String completed) {
        this.completed = completed;
        return this;
    }
}
