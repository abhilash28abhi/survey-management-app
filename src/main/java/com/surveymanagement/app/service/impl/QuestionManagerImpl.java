package com.surveymanagement.app.service.impl;

import com.surveymanagement.app.api.QuestionRequest;
import com.surveymanagement.app.exception.ResourceNotFoundException;
import com.surveymanagement.app.model.Question;
import com.surveymanagement.app.repository.QuestionRepository;
import com.surveymanagement.app.repository.SurveyRepository;
import com.surveymanagement.app.service.IQuestionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Service class which handles various operations that can be performed on a question related to a survey.
 */
@Service
public class QuestionManagerImpl implements IQuestionManager {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question createQuestionForSurvey(long surveyId, QuestionRequest questionRequest) {
        return surveyRepository.findById(surveyId).map(survey -> {
            Question question = new Question();
            question.setSurvey(survey);
            question.setDescription(questionRequest.getDescription());
            question.setActive(questionRequest.isActive());
            question.setCreatedDate(new Date());
            return questionRepository.save(question);
        }).orElseThrow(() -> new ResourceNotFoundException("Survey not found with id : " + surveyId));
    }
}
