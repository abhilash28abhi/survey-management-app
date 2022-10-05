package com.surveymanagement.app.controller;

import com.surveymanagement.app.dto.QuestionRequestDto;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/api/v1")
@Slf4j
@Validated
public class QuestionController {

    @Autowired
    private QuestionManagerImpl questionManager;

    /**
     * API which creates a new question for a given survey id.
     * @param surveyId survey id
     * @param questionRequestDto request body for create question
     * @return response body for the created question
     */
    @Operation(summary = "Create new question for a survey")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Question.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping(value = "/surveys/{surveyId}/questions")
    public ResponseEntity<Question> createQuestionForSurvey (@Min(1) @PathVariable(value = "surveyId") long surveyId,
            @Valid @RequestBody QuestionRequestDto questionRequestDto) {
        log.debug("Inside createQuestionForSurvey method to create question for survey Id : {}", surveyId);
        Question response = questionManager.createQuestionForSurvey(surveyId, questionRequestDto);
        log.debug("Exiting from createQuestionForSurvey method after creating new question");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
