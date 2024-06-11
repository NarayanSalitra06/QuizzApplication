package com.springbootPro.springPro.dou;


import com.springbootPro.springPro.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DouQuiz extends JpaRepository<Quiz,Integer> {
}
