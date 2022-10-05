package com.surveymanagement.app.utils;

import com.surveymanagement.app.model.Question;
import com.surveymanagement.app.model.Survey;

import java.util.Date;

public class TestUtils {

    public static Survey getMockSurvey() {
        Survey survey = new Survey();
        survey.setDescription("test desc")
                .setType("test type")
                .setStatus(SurveyStatusEnum.ACTIVE);
        return survey;
    }

    public static Question getMockQuestion() {
        Question question = new Question();
        question.setDescription("test desc for question");
        question.setActive(true);
        return question;
    }
}
