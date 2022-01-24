package com.codeclan.example.project.components;

import com.codeclan.example.project.models.Answer;
import com.codeclan.example.project.models.Question;
import com.codeclan.example.project.models.User;
import com.codeclan.example.project.repositories.AnswerRepository;
import com.codeclan.example.project.repositories.QuestionRepository;
import com.codeclan.example.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    QuestionRepository questionRepository;

    public DataLoader(){
    }

    public void run(ApplicationArguments args) {

        User alex=new User("alex@gmail.com", "alexalex");
        userRepository.save(alex);

        User stiv=new User("stiv@gmail.com", "stivstiv");
        userRepository.save(stiv);

        User eric=new User("eric@gmail.com", "ericeric");
        userRepository.save(eric);

        Question question1=new Question("You fav color?", "red", "blue", "grey");
        questionRepository.save(question1);

        Answer answer1=new Answer(question1, alex, "red");
        answerRepository.save(answer1);
    }

    }
