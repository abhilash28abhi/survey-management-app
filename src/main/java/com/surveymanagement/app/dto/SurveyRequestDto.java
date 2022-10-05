package com.surveymanagement.app.dto;

import com.surveymanagement.app.model.Survey;
import com.surveymanagement.app.utils.SurveyStatusEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class SurveyRequestDto {

    @NotBlank(message = "Description of the survey is required.")
    private String description;
    @NotBlank(message = "Type of the survey is required.")
    private String type;
    private SurveyStatusEnum status;

    public Survey toSurvey() {
        return new Survey()
                .setDescription(description)
                .setType(type)
                .setStatus(status)
                .setCreatedDate(new Date());
    }
}
