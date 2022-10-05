package com.surveymanagement.app.service;

import com.surveymanagement.app.dto.SurveyRequestDto;
import com.surveymanagement.app.model.Survey;
import com.surveymanagement.app.repository.SurveyRepository;
import com.surveymanagement.app.service.impl.SurveyManagerImpl;
import com.surveymanagement.app.utils.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SurveyManagerTest {

    @InjectMocks
    private SurveyManagerImpl surveyManager;

    @Mock
    private SurveyRepository surveyRepository;

    @Test
    public void createSurvey_success () {
        when(surveyRepository.save(any())).thenReturn(TestUtils.getMockSurvey());
        Survey response = surveyManager.createSurvey(new SurveyRequestDto());
        assertNotNull(response);
        assertEquals("test desc", response.getDescription());
    }
}
