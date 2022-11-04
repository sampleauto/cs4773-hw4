package com.cs4773.Model;

public class Team {
    private int score = 0;
    private String name = "No name provided";
    private String date;

    public void setName(String name) {
        this.name = name;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
    public String getDate() {
        return date;
    }
    @Override
    public String toString() {
        return name + "\t\t" + score;
    }
}
