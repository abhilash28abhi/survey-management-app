package com.surveymanagement.app.model;

import com.surveymanagement.app.utils.SurveyStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import java.util.Date;

@Data
@Entity
@Table(name = "surveys")
@Accessors(chain = true)
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    private long id;

    private String description;

    private String type;

    @Enumerated(EnumType.STRING)
    private SurveyStatusEnum status;

    @Column(name = "created_date")
    private Date createdDate;
}
