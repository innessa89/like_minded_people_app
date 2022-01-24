package com.codeclan.example.project.controllers;

import com.codeclan.example.project.models.Answer;
import com.codeclan.example.project.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnswerController {

    @Autowired
    AnswerRepository answerRepository;

    @GetMapping(value = "/answers")
    public ResponseEntity<List<Answer>> getAllAnswers(){
        return new ResponseEntity<>(answerRepository.findAll(), HttpStatus.OK);
    }

    
}
