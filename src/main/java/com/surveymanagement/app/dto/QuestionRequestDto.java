package com.surveymanagement.app.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class QuestionRequestDto {

    @NotBlank(message = "Description of the question is required.")
    private String description;
    @NotEmpty(message = "Active state value is required.")
    private boolean active;
}
