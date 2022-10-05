package com.surveymanagement.app.controller;

import com.surveymanagement.app.dto.OptionRequestDto;
import com.surveymanagement.app.model.Option;
import com.surveymanagement.app.service.impl.OptionManagerImpl;
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

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class OptionController {

    @Autowired
    private OptionManagerImpl optionManager;

    /**
     * API which creates a new option for a given question id.
     * @param questionId question id
     * @param optionRequestDto request body for create option
     * @return response body for the option created
     */
    @Operation(summary = "Create new option for a question")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Option.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping(value = "/questions/{questionId}/options")
    public ResponseEntity<Option> createOptionForQuestion (@Min(1) @PathVariable long questionId,
            @Valid @RequestBody OptionRequestDto optionRequestDto) {
        log.debug("Inside createOptionForQuestion method to create option for a question Id : {}", questionId);
        Option response = optionManager.createOptionForQuestionId(questionId, optionRequestDto);
        log.debug("Exiting from createOptionForQuestion method after creating new option");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
