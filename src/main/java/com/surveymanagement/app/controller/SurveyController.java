package com.surveymanagement.app.controller;

import com.surveymanagement.app.api.SurveyRequest;
import com.surveymanagement.app.model.Survey;
import com.surveymanagement.app.repository.SurveyRepository;
import com.surveymanagement.app.service.impl.SurveyManagerImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/surveys")
@Slf4j
public class SurveyController {

    @Autowired
    private SurveyManagerImpl surveyManager;

    @PostMapping
    public ResponseEntity<Survey> createSurvey(@RequestBody SurveyRequest request) {
        log.debug("Inside createSurvey method to create new survey");
        Survey response = surveyManager.createSurvey(request);
        log.debug("Exiting from createSurvey method after creating new survey");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
