package com.surveymanagement.app.service.impl;

import com.surveymanagement.app.dto.OptionRequestDto;
import com.surveymanagement.app.exception.ResourceNotFoundException;
import com.surveymanagement.app.model.Option;
import com.surveymanagement.app.repository.OptionRepository;
import com.surveymanagement.app.repository.QuestionRepository;
import com.surveymanagement.app.service.IOptionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Service class which handles various operations that can be performed on an option related to a question.
 */
@Service
public class OptionManagerImpl implements IOptionManager {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private OptionRepository optionRepository;

    @Override
    public Option createOptionForQuestionId(long questionId, OptionRequestDto optionRequestDto) {
        return questionRepository.findById(questionId).map(question -> {
            Option option = new Option();
            option.setQuestion(question);
            option.setDescription(optionRequestDto.getDescription());
            option.setCreatedDate(new Date());
            return optionRepository.save(option);
        }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id : " + questionId));
    }
}
