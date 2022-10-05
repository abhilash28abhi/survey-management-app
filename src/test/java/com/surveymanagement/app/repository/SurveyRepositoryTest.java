package com.surveymanagement.app.repository;

import com.surveymanagement.app.model.Survey;
import com.surveymanagement.app.utils.SurveyStatusEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class SurveyRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    SurveyRepository surveyRepository;

    @Test
    public void save_survey_success() {
        Survey survey = surveyRepository.save(
                new Survey(1, "test desc", "social", SurveyStatusEnum.ACTIVE, new Date()));
        assertThat(survey).hasFieldOrPropertyWithValue("description", "test desc");
        assertThat(survey).hasFieldOrPropertyWithValue("type", "social");
        assertThat(survey).hasFieldOrPropertyWithValue("status", SurveyStatusEnum.ACTIVE);
    }
}
