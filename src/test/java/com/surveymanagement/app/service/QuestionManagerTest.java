package com.surveymanagement.app.service;

import com.surveymanagement.app.dto.QuestionRequestDto;
import com.surveymanagement.app.exception.ResourceNotFoundException;
import com.surveymanagement.app.model.Question;
import com.surveymanagement.app.repository.QuestionRepository;
import com.surveymanagement.app.repository.SurveyRepository;
import com.surveymanagement.app.service.impl.QuestionManagerImpl;
import com.surveymanagement.app.utils.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuestionManagerTest {

    @InjectMocks
    private QuestionManagerImpl questionManager;

    @Mock
    private SurveyRepository surveyRepository;

    @Mock
    private QuestionRepository questionRepository;

    @Test
    public void createQuestionForSurvey_success () {
        when(surveyRepository.findById(anyLong())).thenReturn(Optional.of(TestUtils.getMockSurvey()));
        when(questionRepository.save(any())).thenReturn(TestUtils.getMockQuestion());
        Question response = questionManager.createQuestionForSurvey(1, new QuestionRequestDto());
        assertNotNull(response);
        assertEquals("test desc for question", response.getDescription());
    }

    @Test
    public void createQuestionForSurvey_surveyId_invalid () {
        when(surveyRepository.findById(anyLong())).thenThrow(new ResourceNotFoundException("Survey not found for the id"));
        try {
            questionManager.createQuestionForSurvey(9999, new QuestionRequestDto());
        } catch (Exception e) {
            assertTrue(e instanceof ResourceNotFoundException);
        }
    }
}
