package com.springbootPro.springPro.service;

import java.util.*;
import com.springbootPro.springPro.dou.DouRepo;
import com.springbootPro.springPro.model.Question;

import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    DouRepo dou;
    public ResponseEntity<List<Question>> getAllquestions(){
     try{
        return new ResponseEntity<>(dou.findAll(), HttpStatus.OK) ;
    }
     catch (Exception e){
         e.printStackTrace();
     }
     return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST) ;
    }


    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(dou.findByCategory(category), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST) ;

    }

    public ResponseEntity<String> addQuestion(Question question) {
        dou.save(question);
        return  new ResponseEntity<>("succes",HttpStatus.CREATED);
    }
}
