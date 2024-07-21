package com.yourcompany.reportgenerator.service;

import com.yourcompany.reportgenerator.config.ReportConfig;
import com.yourcompany.reportgenerator.model.InputData;
import com.yourcompany.reportgenerator.model.ReferenceData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FileIngestionServiceTest {

    @Mock
    private ReportConfig reportConfig;

    @InjectMocks
    private FileIngestionService fileIngestionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testIngestInputFile() throws IOException {
        String testInputPath = getClass().getResource("/test-input.csv").getPath();
        when(reportConfig.getInputFilePath()).thenReturn(testInputPath);

        List<InputData> result = fileIngestionService.ingestInputFile();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("value1", result.get(0).getField1());
        assertEquals("value2", result.get(0).getField2());
        assertEquals(10.5, result.get(0).getField5());
    }

    @Test
    void testIngestReferenceFile() throws IOException {
        String testReferencePath = getClass().getResource("/test-reference.csv").getPath();
        when(reportConfig.getReferenceFilePath()).thenReturn(testReferencePath);

        List<ReferenceData> result = fileIngestionService.ingestReferenceFile();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("refkey1", result.get(0).getRefkey1());
        assertEquals("refdata1", result.get(0).getRefdata1());
        assertEquals(20.5, result.get(0).getRefdata4());
    }
}