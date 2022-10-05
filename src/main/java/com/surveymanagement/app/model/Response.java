package com.surveymanagement.app.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "responses")
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "response_id")
    private long id;

}
