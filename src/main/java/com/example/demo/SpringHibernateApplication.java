package com.example.demo;

import com.example.demo.configuration.HibernateConfig;
import com.example.demo.domain.Question;
import com.example.demo.service.QuestionTransactionService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SpringHibernateApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SpringHibernateApplication.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        QuestionTransactionService questionTransactionService = context.getBean("questionTransactionService", QuestionTransactionService.class);

        //get the questions from file
        List<Question> list = readFile("C:\\Users\\Ahmad Saad\\Desktop\\BeaconFireSolutions Training\\Week5\\Day3\\Week5Day3\\src\\main\\java\\com\\example\\demo\\quiz.txt");
        list.forEach(e->System.out.println(e));

        //call service method to process it
        questionTransactionService.addQuestion(list);

//        questionTransactionService.getCountById();
//        QuestionTransaction transaction = new QuestionTransaction();
//        transaction.setId(1);
//        transaction.setDate("09/09/2020");
//        transaction.setCountQuestions(2);
//        questionTransactionService.saveTransaction(transaction);

    }

    public static List<Question> readFile(String filename){

        List<Question> list = new ArrayList<>();

        File file = new File(filename);
        Scanner sc = null;
        int i = 35;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String val[] = line.split("[|]");
                Question question = new Question();
                question.setId(i);
                question.setType(val[0].trim());
                question.setText(val[1].trim());
                question.setQuestionOptions(val[2].trim());
                question.setCorrectOptionIndex(Integer.parseInt(val[3].trim()));
                i++;
                list.add(question);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return list;

    }

}
