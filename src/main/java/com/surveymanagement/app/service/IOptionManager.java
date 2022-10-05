package com.surveymanagement.app.service;

import com.surveymanagement.app.dto.OptionRequestDto;
import com.surveymanagement.app.model.Option;

public interface IOptionManager {

    Option createOptionForQuestionId(long questionId, OptionRequestDto optionRequestDto);
}
