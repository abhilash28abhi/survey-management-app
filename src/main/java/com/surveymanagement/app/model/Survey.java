package com.surveymanagement.app.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "surveys")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    private long id;

    private String description;

    private String type;

    @Column(name = "created_date")
    private Date createdDate;
}
