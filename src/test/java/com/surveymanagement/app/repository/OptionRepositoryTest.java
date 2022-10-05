package com.surveymanagement.app.repository;

import com.surveymanagement.app.model.Option;
import com.surveymanagement.app.model.Question;
import com.surveymanagement.app.model.Survey;
import com.surveymanagement.app.utils.SurveyStatusEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class OptionRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    OptionRepository optionRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Test
    public void save_option_success() {
        surveyRepository.save(
                new Survey(1, "test desc", "social", SurveyStatusEnum.ACTIVE, new Date()));
        questionRepository.save(new Question(1, "test desc", true, new Date(), new Survey(1, "s1", "close", SurveyStatusEnum.ACTIVE, new Date())));
        Option option = optionRepository.save(
                new Option(1, "test desc", new Date(), new Question(1, "test desc", true, new Date(), new Survey(1, "s1", "close", SurveyStatusEnum.ACTIVE, new Date()))));
        assertThat(option).hasFieldOrPropertyWithValue("description", "test desc");
    }
}
