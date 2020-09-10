package com.example.demo.service;

import com.example.demo.dao.QuestionDao;
import com.example.demo.dao.TransactionDao;
import com.example.demo.domain.Question;
import com.example.demo.domain.QuestionTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.Assert;

import java.util.List;

@Component
public class QuestionTransactionService {

    private TransactionDao transactionDao;
    private QuestionDao questionDao;
    private final TransactionTemplate transactionTemplate;

    // use constructor-injection to supply the PlatformTransactionManager
    public QuestionTransactionService(PlatformTransactionManager transactionManager) {
        Assert.notNull(transactionManager, "The 'transactionManager' argument must not be null.");
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }


    @Autowired
    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Autowired
    public void setTransactionDao(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    /*
    @Transactional
    public void getCountById() {
        int transaction = transactionDao.getCountQuestion(1);
        //transactionDao.saveTransaction();
        System.out.println(transaction);
    }
    */

    @Transactional
    public void saveTransaction(QuestionTransaction questionTransaction) {
        transactionDao.saveTransaction(questionTransaction);
    }


    public void addQuestion(List<Question> question) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            // the code in this method executes in a transactional context
            public void doInTransactionWithoutResult(TransactionStatus status) {

                QuestionTransaction questionTransaction = new QuestionTransaction();
                questionTransaction.setDate("09/09/2020");
                questionTransaction.setId(1);
                int c = questionDao.addQuestion(question);
                System.out.println(c);
                questionTransaction.setCountQuestions(c);
                transactionDao.saveTransaction(questionTransaction);
                saveTransaction(questionTransaction); //giving me errors

            }
        });
    }
}
