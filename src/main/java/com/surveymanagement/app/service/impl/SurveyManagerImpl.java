package com.surveymanagement.app.service.impl;

import com.surveymanagement.app.api.SurveyRequest;
import com.surveymanagement.app.model.Survey;
import com.surveymanagement.app.repository.SurveyRepository;
import com.surveymanagement.app.service.ISurveyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Service class which handles various operations that can be performed on a survey.
 */
@Service
public class SurveyManagerImpl implements ISurveyManager {

    @Autowired
    private SurveyRepository surveyRepository;

    @Override public Survey createSurvey(SurveyRequest request) {
        Survey survey = new Survey();
        survey.setDescription(request.getDescription());
        survey.setType(request.getType());
        survey.setStatus(request.getStatus());
        survey.setCreatedDate(new Date());
        return surveyRepository.save(survey);
    }
}
