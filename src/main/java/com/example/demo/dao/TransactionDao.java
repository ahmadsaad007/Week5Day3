package com.example.demo.dao;

import com.example.demo.domain.QuestionTransaction;

public interface TransactionDao {

    public int getCountQuestion(int transactionId);
    public void saveTransaction(QuestionTransaction questionTransaction);
}
