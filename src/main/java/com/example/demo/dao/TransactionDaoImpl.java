package com.example.demo.dao;

import com.example.demo.domain.QuestionTransaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("transactionDao")
public class TransactionDaoImpl extends AbstractHibernateDAO<QuestionTransaction> implements TransactionDao {

    @Autowired
    private SessionFactory sessionFactory;

    public TransactionDaoImpl(){
        setClazz(QuestionTransaction.class);
    }

    @Transactional
    public int getCountQuestion(int transactionId) {
        //Session session = sessionFactory.getCurrentSession();
        return 0;
    }

    @Transactional
    public void saveTransaction(QuestionTransaction questionTransaction) {
        Session session = sessionFactory.getCurrentSession();
        session.save(questionTransaction);
        System.out.println("Saving questionTransaction");
    }
}
