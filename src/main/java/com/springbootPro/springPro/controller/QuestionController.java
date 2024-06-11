package com.springbootPro.springPro.controller;
import java.util.*;
import com.springbootPro.springPro.model.Question;
import com.springbootPro.springPro.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestion() {
        return questionService.getAllquestions();
    }

    @GetMapping("category/{category}")
    public  ResponseEntity<List<Question>> getQuestionByCategory( @PathVariable String category){

      return questionService.getQuestionByCategory(category);
    }

    @PostMapping("addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){

        return questionService.addQuestion(question);
    }
}

