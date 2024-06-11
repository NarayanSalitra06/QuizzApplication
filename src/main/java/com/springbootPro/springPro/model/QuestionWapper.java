package com.springbootPro.springPro.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data

public class QuestionWapper {

    private int id;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String questionTitle;

    public QuestionWapper(int id, String option1, String option2, String option3, String option4, String questionTitle) {
        this.id = id;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.questionTitle = questionTitle;
    }
}
