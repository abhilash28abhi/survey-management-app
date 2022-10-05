package com.surveymanagement.app.api;

import com.surveymanagement.app.utils.SurveyStatusEnum;
import lombok.Data;

@Data
public class SurveyRequest {

    private String description;
    private String type;
    private boolean active;
    private SurveyStatusEnum status;
}
