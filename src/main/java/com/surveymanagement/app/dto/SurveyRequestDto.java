package com.surveymanagement.app.dto;

import com.surveymanagement.app.utils.SurveyStatusEnum;
import lombok.Data;

@Data
public class SurveyRequestDto {

    private String description;
    private String type;
    private boolean active;
    private SurveyStatusEnum status;
}
