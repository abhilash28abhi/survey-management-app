package com.surveymanagement.app.api;

import lombok.Data;

@Data
public class QuestionRequest {

    private String description;
    private boolean active;
}
