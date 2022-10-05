package com.surveymanagement.app.api;

import lombok.Data;

@Data
public class SurveyRequest {

    private String description;
    private String type;
    private boolean active;
}
