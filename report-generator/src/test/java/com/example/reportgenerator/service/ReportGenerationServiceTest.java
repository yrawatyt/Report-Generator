package com.yourcompany.reportgenerator.service;

import com.yourcompany.reportgenerator.config.ReportConfig;
import com.yourcompany.reportgenerator.model.InputData;
import com.yourcompany.reportgenerator.model.OutputData;
import com.yourcompany.reportgenerator.model.ReferenceData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ReportGenerationServiceTest {

    @Mock
    private FileIngestionService fileIngestionService;

    @Mock
    private TransformationService transformationService;

    @Mock
    private ReportConfig reportConfig;

    @InjectMocks
    private ReportGenerationService reportGenerationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGenerateReport() throws IOException {
        // Prepare test data
        InputData input1 = new InputData("field1", "field2", "3", "field4", 10.0, "refkey1", "refkey2");
        InputData input2 = new InputData("field1", "field2", "3", "field4", 20.0, "refkey3", "refkey4");
        List<InputData> inputDataList = Arrays.asList(input1, input2);

        ReferenceData ref1 = new ReferenceData("refkey1", "refdata1", "refkey2", "refdata2", "refdata3", 20.0);
        ReferenceData ref2 = new ReferenceData("refkey3", "refdata1", "refkey4", "refdata2", "refdata3", 30.0);
        List<ReferenceData> referenceDataList = Arrays.asList(ref1, ref2);

        OutputData output1 = new OutputData("out1", "out2", "out3", 40.0, 20.0);
        OutputData output2 = new OutputData("out1", "out2", "out3", 60.0, 30.0);

        // Mock dependencies
        when(fileIngestionService.ingestInputFile()).thenReturn(inputDataList);
        when(fileIngestionService.ingestReferenceFile()).thenReturn(referenceDataList);
        when(transformationService.transform(input1, ref1)).thenReturn(output1);
        when(transformationService.transform(input2, ref2)).thenReturn(output2);
        when(reportConfig.getOutputFilePath()).thenReturn("/tmp/test-output.csv");

        // Execute the method
        reportGenerationService.generateReport();

        // Verify the interactions
        verify(fileIngestionService).ingestInputFile();
        verify(fileIngestionService).ingestReferenceFile();
        verify(transformationService).transform(input1, ref1);
        verify(transformationService).transform(input2, ref2);
        // You might want to add more verifications here, such as checking if the output file was written correctly
    }
}