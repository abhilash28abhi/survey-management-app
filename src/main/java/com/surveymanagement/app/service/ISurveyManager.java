package com.surveymanagement.app.service;

import com.surveymanagement.app.dto.SurveyRequestDto;
import com.surveymanagement.app.model.Survey;

public interface ISurveyManager {

    Survey createSurvey(SurveyRequestDto request);
}
