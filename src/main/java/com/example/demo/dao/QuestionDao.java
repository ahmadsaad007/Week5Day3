package com.example.demo.dao;

import com.example.demo.domain.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("questionDao")
public class QuestionDao extends AbstractHibernateDAO<Question> {

    @Autowired
    private SessionFactory sessionFactory;

    public QuestionDao(){
        setClazz(Question.class);
    }
    //(noRollbackFor = InvalidQuestionEntry.class)
    @Transactional
    public int addQuestion(List<Question> questions){
        Session session = sessionFactory.getCurrentSession();
        int i =0;
        int count = 0;
        try {
            while (i < questions.size()) {
                if (questions.get(i).getCorrectOptionIndex() < 0 || questions.get(i).getCorrectOptionIndex() > 3) {
                    throw new InvalidQuestionEntry();
                }
                if (i % 5 == 0) {
                    session.flush();
                    count++;
                }
                session.save(questions.get(i));
                i++;
            }
        }
        catch (InvalidQuestionEntry entry){
            System.out.println(entry);
        }
        return count;
    }


}

