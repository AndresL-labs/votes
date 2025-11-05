package com.example.votes.model;

public class VoteRequest {
    private int questionId;
    private int option;

    public int getQuestionId() { return questionId; }
    public void setQuestionId(int questionId) { this.questionId = questionId; }

    public int getOption() { return option; }
    public void setOption(int option) { this.option = option; }
}
