package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "question")
public class Question implements Serializable {
    @Id
    @Column(name = "questionId")
    private int id;
    @Column(name = "questionText")
    private String text;
    @Column(name = "questionType")
    private String type;
    @Column(name = "optionText")
    private String questionOptions;
    @Column(name = "correctIndex")
    private int correctOptionIndex;

    public Question() {
    }

    public Question(int id, String text, String type, String questionOptions, int correctOptionIndex) {
        this.id = id;
        this.text =text;
        this.type = type;
        this.questionOptions = questionOptions;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(String questionOptions) {
        this.questionOptions = questionOptions;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }

    public void setCorrectOptionIndex(int correctOptionIndex) {
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }
}
