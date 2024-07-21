package com.example.reportgenerator.service;

import com.example.reportgenerator.config.ReportConfig;
import com.example.reportgenerator.model.InputData;
import com.example.reportgenerator.model.OutputData;
import com.example.reportgenerator.model.ReferenceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportGenerationService {

    private static final Logger logger = LoggerFactory.getLogger(ReportGenerationService.class);

    @Autowired
    private FileIngestionService fileIngestionService;

    @Autowired
    private TransformationService transformationService;

    @Autowired
    private ReportConfig reportConfig;

    /**
     * Generates the report by ingesting input and reference files, transforming the data, and writing the results to an output file.
     */
    public void generateReport() {
        try {
            List<InputData> inputDataList = fileIngestionService.ingestInputFile();
            List<ReferenceData> referenceDataList = fileIngestionService.ingestReferenceFile();

            List<OutputData> outputDataList = new ArrayList<>();

            for (InputData input : inputDataList) {
                try {
                    ReferenceData reference = findMatchingReference(input, referenceDataList);
                    OutputData output = transformationService.transform(input, reference);
                    outputDataList.add(output);
                } catch (RuntimeException e) {
                    logger.warn("Skipping input due to missing reference: {}", input, e);
                }
            }

            writeOutputFile(outputDataList);
        } catch (IOException e) {
            logger.error("Error occurred while generating the report", e);
        }
    }

    /**
     * Finds the matching reference data for a given input data.
     *
     * @param input The input data.
     * @param referenceDataList The list of reference data.
     * @return The matching reference data.
     * @throws RuntimeException If no matching reference data is found.
     */
    private ReferenceData findMatchingReference(InputData input, List<ReferenceData> referenceDataList) {
        return referenceDataList.stream()
                .filter(ref -> ref.getRefkey1().equals(input.getRefkey1()) && ref.getRefkey2().equals(input.getRefkey2()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No matching reference data found for input: " + input));
    }

    /**
     * Writes the output data to the specified output file.
     *
     * @param outputDataList The list of output data.
     * @throws IOException If an error occurs while writing to the file.
     */
    private void writeOutputFile(List<OutputData> outputDataList) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(reportConfig.getOutputFilePath()))) {
            for (OutputData output : outputDataList) {
                bw.write(String.format("%s,%s,%s,%.2f,%.2f\n",
                        output.getOutfield1(),
                        output.getOutfield2(),
                        output.getOutfield3(),
                        output.getOutfield4(),
                        output.getOutfield5()));
            }
        }
    }
}
