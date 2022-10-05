package com.surveymanagement.app.service;

import com.surveymanagement.app.api.SurveyRequest;
import com.surveymanagement.app.model.Survey;

public interface ISurveyManager {

    Survey createSurvey(SurveyRequest request);
}
