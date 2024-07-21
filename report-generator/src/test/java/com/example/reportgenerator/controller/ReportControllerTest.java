package com.yourcompany.reportgenerator.controller;

import com.yourcompany.reportgenerator.service.ReportGenerationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReportControllerTest {

    @Mock
    private ReportGenerationService reportGenerationService;

    @InjectMocks
    private ReportController reportController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGenerateReportSuccess() throws IOException {
        doNothing().when(reportGenerationService).generateReport();

        ResponseEntity<String> response = reportController.generateReport();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Report generated successfully", response.getBody());
        verify(reportGenerationService, times(1)).generateReport();
    }

    @Test
    void testGenerateReportFailure() throws IOException {
        doThrow(new IOException("Test error")).when(reportGenerationService).generateReport();

        ResponseEntity<String> response = reportController.generateReport();

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertTrue(response.getBody().startsWith("Error generating report:"));
        verify(reportGenerationService, times(1)).generateReport();
    }
}