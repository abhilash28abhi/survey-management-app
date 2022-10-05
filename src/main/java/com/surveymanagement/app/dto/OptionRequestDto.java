package com.surveymanagement.app.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OptionRequestDto {

    @NotBlank(message = "Description of the question is required.")
    private String description;
}
