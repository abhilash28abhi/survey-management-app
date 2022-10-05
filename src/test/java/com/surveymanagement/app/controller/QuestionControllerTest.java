package com.surveymanagement.app.controller;

import com.surveymanagement.app.dto.QuestionRequestDto;
import com.surveymanagement.app.dto.SurveyRequestDto;
import com.surveymanagement.app.exception.ResourceNotFoundException;
import com.surveymanagement.app.model.Question;
import com.surveymanagement.app.model.Survey;
import com.surveymanagement.app.service.impl.QuestionManagerImpl;
import com.surveymanagement.app.service.impl.SurveyManagerImpl;
import com.surveymanagement.app.utils.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuestionControllerTest {

    @Mock
    private QuestionManagerImpl manager;

    @InjectMocks
    private QuestionController questionController;

    @Test
    public void createQuestionForSurvey_success () {
        when(manager.createQuestionForSurvey(anyLong(), any())).thenReturn(TestUtils.getMockQuestion());
        ResponseEntity<?> resp = questionController.createQuestionForSurvey(1, new QuestionRequestDto());
        assertEquals(HttpStatus.CREATED, resp.getStatusCode());
        Question respBody = (Question) resp.getBody();
        assertEquals("test desc for question", respBody.getDescription());
    }

    @Test
    public void createQuestionForSurvey_invalidSurveyId () {
        lenient().doThrow(new ResourceNotFoundException("Invalid Id passed")).when(manager).createQuestionForSurvey(anyLong(), any());
        try {
            questionController.createQuestionForSurvey(9999, new QuestionRequestDto());
        } catch (Exception e) {
            assertTrue(e instanceof ResourceNotFoundException);
        }
    }
}
