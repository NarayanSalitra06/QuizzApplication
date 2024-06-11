package com.springbootPro.springPro.service;


import com.springbootPro.springPro.dou.DouQuiz;
import com.springbootPro.springPro.dou.DouRepo;
import com.springbootPro.springPro.model.Question;
import com.springbootPro.springPro.model.QuestionWapper;
import com.springbootPro.springPro.model.Quiz;
import com.springbootPro.springPro.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    DouQuiz douQuiz;

    @Autowired
    DouRepo douRepo;

    public ResponseEntity<String> createQuiz(String category, String title ,int numQ) {
        Quiz quiz =new Quiz();
        List<Question> questions= douRepo.findRandomQuestionByCategory(category,numQ);
        quiz.setQuestions(questions);
        quiz.setTitle(title);
        douQuiz.save(quiz);
        return new ResponseEntity<>("succes", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWapper>> getQuizQuestion(int id) {

        Optional<Quiz> quiz=douQuiz.findById(id);
        List<Question> questionFromDB=quiz.get().getQuestions();
        List<QuestionWapper> questionForUser=new ArrayList<>();
        for(Question q:questionFromDB){
            QuestionWapper qw=new QuestionWapper(q.getId(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getQuestionTitle());
            questionForUser.add(qw);
        }
        return  new ResponseEntity<>(questionForUser, HttpStatus.OK);
    }


    public ResponseEntity<Integer> getResult(Integer id, List<Response> responses) {
        Quiz quiz = douQuiz.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int count = 0;
            int i=0;
        for (Response response:responses){
            if (response.getResponse().equals(questions.get(i).getRightAnswer()))
                count++;



                i++;
        }
        return new ResponseEntity<>(count,HttpStatus.OK);
    }
}
