package com.surveymanagement.app.controller;

import com.surveymanagement.app.api.QuestionRequest;
import com.surveymanagement.app.model.Question;
import com.surveymanagement.app.service.impl.QuestionManagerImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class QuestionController {

    @Autowired
    private QuestionManagerImpl questionManager;

    /**
     * API which creates a new question for a given survey id.
     * @param surveyId survey id
     * @param questionRequest request body for create question
     * @return response body for the created question
     */
    @Operation(summary = "Create new question for a survey")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Question.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
    })
    @PostMapping(value = "/surveys/{surveyId}/questions")
    public ResponseEntity<Question> createQuestionForSurvey (@PathVariable(value = "surveyId") long surveyId,
            @RequestBody QuestionRequest questionRequest) {
        log.debug("Inside createQuestionForSurvey method to create question for survey Id : {}", surveyId);
        Question response = questionManager.createQuestionForSurvey(surveyId, questionRequest);
        log.debug("Exiting from createQuestionForSurvey method after creating new question");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
