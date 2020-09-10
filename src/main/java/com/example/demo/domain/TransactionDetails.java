package com.example.demo.domain;

import javax.persistence.*;

@Entity
@Table(name = "transactionhistorydetails")
public class TransactionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    QuestionTransaction transactionId;
    String questionText;
    String questionType;
    String questionOptions;
    int correctIndex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public QuestionTransaction getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(QuestionTransaction questionTransactionId) {
        this.transactionId = questionTransactionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(String questionOptions) {
        this.questionOptions = questionOptions;
    }

    public int getCorrectIndex() {
        return correctIndex;
    }

    public void setCorrectIndex(int correctIndex) {
        this.correctIndex = correctIndex;
    }
}
