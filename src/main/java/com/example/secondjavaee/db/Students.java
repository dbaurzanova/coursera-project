package com.example.secondjavaee.db;

public class Students {

    private Long id;
    private String email;
    private String password;
    private String full_name;
    private String group;
    private String gpa;
    private int test_is_done;
    private int score;

    public Students() {
    }

    public Students(Long id, String email, String password, String full_name, String group, String gpa, int text_is_done, int score) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.full_name = full_name;
        this.group = group;
        this.gpa = gpa;
        this.test_is_done = text_is_done;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public int getTest_is_done() {
        return test_is_done;
    }

    public void setTest_is_done(int text_is_done) {
        this.test_is_done = text_is_done;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
