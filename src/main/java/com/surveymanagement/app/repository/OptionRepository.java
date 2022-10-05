package com.surveymanagement.app.repository;

import com.surveymanagement.app.model.Option;
import com.surveymanagement.app.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {

    List<Question> findByQuestionId(Long questionId);
}
