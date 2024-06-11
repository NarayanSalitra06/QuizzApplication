package com.springbootPro.springPro.controller;

import com.springbootPro.springPro.model.Question;
import com.springbootPro.springPro.model.QuestionWapper;

import com.springbootPro.springPro.model.Response;


import com.springbootPro.springPro.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@Controller
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam String title, @RequestParam int numQ) {

        return quizService.createQuiz(category, title, numQ);
    }

    @GetMapping("get/{id}")
    public  ResponseEntity<List<QuestionWapper>> getQuizQuestion(@PathVariable int id){

       return quizService.getQuizQuestion(id);

    }
    @PostMapping("getScoure/{id}")
    public ResponseEntity<Integer> getResult(@PathVariable Integer  id,@RequestBody List<Response> responses){
         return quizService.getResult(id, responses);
    }

}
