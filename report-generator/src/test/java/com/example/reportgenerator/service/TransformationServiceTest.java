package com.yourcompany.reportgenerator.service;

import com.yourcompany.reportgenerator.model.InputData;
import com.yourcompany.reportgenerator.model.OutputData;
import com.yourcompany.reportgenerator.model.ReferenceData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransformationServiceTest {

    private TransformationService transformationService;

    @BeforeEach
    void setUp() {
        transformationService = new TransformationService();
    }

    @Test
    void testTransform() {
        InputData input = new InputData("field1", "field2", "3", "field4", 10.0, "refkey1", "refkey2");
        ReferenceData reference = new ReferenceData("refkey1", "refdata1", "refkey2", "refdata2", "refdata3", 20.0);

        OutputData result = transformationService.transform(input, reference);

        assertNotNull(result);
        assertEquals("field1field2", result.getOutfield1());
        assertEquals("refdata1", result.getOutfield2());
        assertEquals("refdata2refdata3", result.getOutfield3());
        assertEquals(60.0, result.getOutfield4());
        assertEquals(20.0, result.getOutfield5());
    }
}