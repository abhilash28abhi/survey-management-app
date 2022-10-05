package com.surveymanagement.app.service;

import com.surveymanagement.app.api.QuestionRequest;
import com.surveymanagement.app.model.Question;

public interface IQuestionManager {

    Question createQuestionForSurvey(long surveyId, QuestionRequest questionRequest);
}
