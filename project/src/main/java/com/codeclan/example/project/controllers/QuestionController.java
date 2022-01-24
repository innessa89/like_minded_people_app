package com.codeclan.example.project.controllers;

import com.codeclan.example.project.models.Answer;
import com.codeclan.example.project.models.Question;
import com.codeclan.example.project.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    @GetMapping(value = "/questions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/questions/{id}")
    public ResponseEntity<Optional<Question>> findQuestion(@PathVariable Long id) {
        Optional<Question> payload = questionRepository.findById(id);
        if (payload.isPresent()) {
            return new ResponseEntity<>(payload, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(payload, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/questions")
    public ResponseEntity<Question> postQuestion(@RequestBody Question question){
        questionRepository.save(question);
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }
}

