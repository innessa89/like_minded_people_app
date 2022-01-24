package com.codeclan.example.project.controllers;
import com.codeclan.example.project.models.Answer;
import com.codeclan.example.project.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class AnswerController {

    @Autowired
    AnswerRepository answerRepository;

    @GetMapping(value = "/answers")
    public ResponseEntity<List<Answer>> getAllAnswers(){
        return new ResponseEntity<>(answerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/answers/{id}")
    public ResponseEntity<Optional<Answer>> getAnswer(@PathVariable Long id){
        Optional<Answer> payload=answerRepository.findById(id);
        if(payload.isPresent()){
            return new ResponseEntity<>(payload, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(payload, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/answers")
    public ResponseEntity<Answer> postPirate(@RequestBody Answer answer){
        answerRepository.save(answer);
        return new ResponseEntity<>(answer, HttpStatus.CREATED);
    }



}
