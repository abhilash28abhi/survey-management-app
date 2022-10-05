package com.surveymanagement.app.dto;

import lombok.Data;

@Data
public class QuestionRequestDto {

    private String description;
    private boolean active;
}
