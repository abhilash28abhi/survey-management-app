package com.surveymanagement.app.repository;

import com.surveymanagement.app.model.Question;
import com.surveymanagement.app.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Survey> findBySurveyId(Long surveyId);
}
