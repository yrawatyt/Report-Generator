package com.example.reportgenerator.service;

import com.example.reportgenerator.model.InputData;
import com.example.reportgenerator.model.ReferenceData;
import com.example.reportgenerator.config.ReportConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileIngestionService {

    private static final Logger logger = LoggerFactory.getLogger(FileIngestionService.class);

    @Autowired
    private ReportConfig reportConfig;

    public List<InputData> ingestInputFile() throws IOException {
        List<InputData> inputDataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(reportConfig.getInputFilePath()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length != 7) {
                    logger.warn("Invalid input line: {}", line);
                    continue; // Skip invalid lines
                }
                try {
                    InputData inputData = new InputData(
                            values[0], values[1], values[2], values[3],
                            Double.parseDouble(values[4]), values[5], values[6]
                    );
                    inputDataList.add(inputData);
                } catch (NumberFormatException e) {
                    logger.warn("Invalid number format in line: {}", line, e);
                }
            }
        } catch (IOException e) {
            logger.error("Error reading input file", e);
            throw e;
        }
        return inputDataList;
    }

    public List<ReferenceData> ingestReferenceFile() throws IOException {
        List<ReferenceData> referenceDataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(reportConfig.getReferenceFilePath()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length != 6) {
                    logger.warn("Invalid reference line: {}", line);
                    continue; // Skip invalid lines
                }
                try {
                    ReferenceData referenceData = new ReferenceData(
                            values[0], values[1], values[2], values[3], values[4], Double.parseDouble(values[5])
                    );
                    referenceDataList.add(referenceData);
                } catch (NumberFormatException e) {
                    logger.warn("Invalid number format in line: {}", line, e);
                }
            }
        } catch (IOException e) {
            logger.error("Error reading reference file", e);
            throw e;
        }
        return referenceDataList;
    }
}
