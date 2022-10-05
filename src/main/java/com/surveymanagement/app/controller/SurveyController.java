package com.surveymanagement.app.controller;

import com.surveymanagement.app.dto.SurveyRequestDto;
import com.surveymanagement.app.model.Survey;
import com.surveymanagement.app.service.impl.SurveyManagerImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/surveys")
@Slf4j
public class SurveyController {

    @Autowired
    private SurveyManagerImpl surveyManager;

    /**
     * API which creates a new survey.
     * @param request request body for create survey
     * @return survey response body
     */
    @Operation(summary = "Create a new survey")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Survey.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
    })
    @PostMapping
    public ResponseEntity<Survey> createSurvey(@Valid @RequestBody SurveyRequestDto request) {
        log.debug("Inside createSurvey method to create new survey");
        Survey response = surveyManager.createSurvey(request);
        log.debug("Exiting from createSurvey method after creating new survey");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
