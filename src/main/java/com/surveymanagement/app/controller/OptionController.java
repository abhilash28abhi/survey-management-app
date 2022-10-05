package com.surveymanagement.app.controller;

import com.surveymanagement.app.api.OptionRequest;
import com.surveymanagement.app.exception.ResourceNotFoundException;
import com.surveymanagement.app.model.Option;
import com.surveymanagement.app.repository.OptionRepository;
import com.surveymanagement.app.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1")
public class OptionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private OptionRepository optionRepository;

    @PostMapping(value = "/questions/{questionId}/options")
    public ResponseEntity<Option> createOption (@PathVariable long questionId,
            @RequestBody OptionRequest optionRequest) {
        Option response = questionRepository.findById(questionId).map(question -> {
            Option option = new Option();
            option.setQuestion(question);
            option.setDescription(optionRequest.getDescription());
            option.setCreatedDate(new Date());
            return optionRepository.save(option);
        }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id : " + questionId));

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
