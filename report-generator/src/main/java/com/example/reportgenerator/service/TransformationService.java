package com.example.reportgenerator.service;

import com.example.reportgenerator.model.InputData;
import com.example.reportgenerator.model.OutputData;
import com.example.reportgenerator.model.ReferenceData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TransformationService {

    private static final Logger logger = LoggerFactory.getLogger(TransformationService.class);

    /**
     * Transforms the input data and reference data into output data.
     *
     * @param input The input data.
     * @param reference The reference data.
     * @return The transformed output data.
     */
    public OutputData transform(InputData input, ReferenceData reference) {
        if (input == null || reference == null) {
            logger.error("Input or Reference data is null");
            throw new IllegalArgumentException("Input or Reference data cannot be null");
        }

        OutputData output = new OutputData();

        try {
            output.setOutfield1(input.getField1() + input.getField2());
            output.setOutfield2(reference.getRefdata1());
            output.setOutfield3(reference.getRefdata2() + reference.getRefdata3());
            output.setOutfield4(input.getField3() * Math.max(input.getField5(), reference.getRefdata4()));
            output.setOutfield5(Math.max(input.getField5(), reference.getRefdata4()));
        } catch (Exception e) {
            logger.error("Error during transformation", e);
            throw new RuntimeException("Transformation failed for input: " + input + " and reference: " + reference, e);
        }

        logger.info("Transformation successful for input: {} and reference: {}", input, reference);
        return output;
    }
}
