package com.surveymanagement.app.controller;

import com.surveymanagement.app.api.QuestionRequest;
import com.surveymanagement.app.exception.ResourceNotFoundException;
import com.surveymanagement.app.model.Question;
import com.surveymanagement.app.repository.QuestionRepository;
import com.surveymanagement.app.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1")
public class QuestionController {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping(value = "/surveys/{surveyId}/questions")
    public ResponseEntity<Question> createQuestion (@PathVariable(value = "surveyId") long surveyId,
            @RequestBody QuestionRequest questionRequest) {
        Question response = surveyRepository.findById(surveyId).map(survey -> {
            Question question = new Question();
            question.setSurvey(survey);
            question.setDescription(questionRequest.getDescription());
            question.setActive(questionRequest.isActive());
            question.setCreatedDate(new Date());
            return questionRepository.save(question);
        }).orElseThrow(() -> new ResourceNotFoundException("Survey not found with id : " + surveyId));

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
