package com.surveymanagement.app.service.impl;

import com.surveymanagement.app.dto.SurveyRequestDto;
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

    @Override public Survey createSurvey(SurveyRequestDto request) {
        return surveyRepository.save(request.toSurvey());
    }
}
