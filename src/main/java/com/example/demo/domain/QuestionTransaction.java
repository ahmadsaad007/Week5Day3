package com.example.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "transactionhistory")
public class QuestionTransaction implements Serializable {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "date")
    private String date;
    @Column(name = "countQuestions")
    private int countQuestions;

//    @OneToMany
//    List<TransactionDetails> list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCountQuestions() {
        return countQuestions;
    }

    public void setCountQuestions(int countQuestions) {
        this.countQuestions = countQuestions;
    }
}
