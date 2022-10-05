package com.surveymanagement.app.service;

import com.surveymanagement.app.dto.QuestionRequestDto;
import com.surveymanagement.app.model.Question;

public interface IQuestionManager {

    Question createQuestionForSurvey(long surveyId, QuestionRequestDto questionRequestDto);
}
