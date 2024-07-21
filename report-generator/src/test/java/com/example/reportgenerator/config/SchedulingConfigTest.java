package com.example.reportgenerator.config;

import com.example.reportgenerator.service.ReportGenerationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

class SchedulingConfigTest {

    @Mock
    private ReportGenerationService reportGenerationService;

    @InjectMocks
    private SchedulingConfig schedulingConfig;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testScheduleReportGeneration() throws IOException {
        doNothing().when(reportGenerationService).generateReport();

        schedulingConfig.scheduleReportGeneration();

        verify(reportGenerationService, times(1)).generateReport();
    }

    @Test
    void testScheduleReportGenerationWithException() throws IOException {
        doThrow(new IOException("Test error")).when(reportGenerationService).generateReport();

        schedulingConfig.scheduleReportGeneration();

        verify(reportGenerationService, times(1)).generateReport();
        // You might want to add more assertions here to check how the exception is handled
    }
}