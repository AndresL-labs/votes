package com.example.votes.model;

public class Question {
    private int id;
    private String text;
    private String[] options;
    private int[] votes;

    public Question(int id, String text, String[] options) {
        this.id = id;
        this.text = text;
        this.options = options;
    }

    public int getId() { return id; }
    public String getText() { return text; }
    public String[] getOptions() { return options; }

    public int[] getVotes() {
        return votes;
    }

    public void setVotes(int[] votes) {
        this.votes = votes;
    }
}
