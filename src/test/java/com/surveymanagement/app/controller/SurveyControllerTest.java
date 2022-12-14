package com.surveymanagement.app.controller;

import com.surveymanagement.app.dto.SurveyRequestDto;
import com.surveymanagement.app.model.Survey;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SurveyControllerTest {

    @Mock
    private SurveyManagerImpl manager;

    @InjectMocks
    private SurveyController surveyController;

    @Test
    public void createSurvey_success () {
        when(manager.createSurvey(any())).thenReturn(TestUtils.getMockSurvey());
        ResponseEntity<?> resp = surveyController.createSurvey(new SurveyRequestDto());
        assertEquals(HttpStatus.CREATED, resp.getStatusCode());
        Survey respBody = (Survey) resp.getBody();
        assertEquals("test desc", respBody.getDescription());
    }
}
