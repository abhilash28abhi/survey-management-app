package com.surveymanagement.app.service.impl;

import com.surveymanagement.app.api.SurveyRequest;
import com.surveymanagement.app.model.Survey;
import com.surveymanagement.app.repository.SurveyRepository;
import com.surveymanagement.app.service.ISurveyManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class SurveyManagerImpl implements ISurveyManager {

    @Autowired
    private SurveyRepository surveyRepository;

    @Override public Survey createSurvey(SurveyRequest request) {
        Survey survey = new Survey();
        survey.setDescription(request.getDescription());
        survey.setType(request.getType());
        survey.setCreatedDate(new Date());
        return surveyRepository.save(survey);
    }
}