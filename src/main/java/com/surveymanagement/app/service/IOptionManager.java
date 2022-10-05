package com.surveymanagement.app.service;

import com.surveymanagement.app.api.OptionRequest;
import com.surveymanagement.app.model.Option;

public interface IOptionManager {

    Option createOptionForQuestionId(long questionId, OptionRequest optionRequest);
}
