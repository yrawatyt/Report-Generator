package com.example.reportgenerator.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "report")
public class ReportConfig {

    private String inputFormat;
    private String outputFormat;
    private String inputFilePath;
    private String referenceFilePath;
    private String outputFilePath;
    private List<String> transformationRules;

    // Getters and setters for all fields

    public String getInputFormat() {
        return inputFormat;
    }

    public void setInputFormat(String inputFormat) {
        this.inputFormat = inputFormat;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public void setInputFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public String getReferenceFilePath() {
        return referenceFilePath;
    }

    public void setReferenceFilePath(String referenceFilePath) {
        this.referenceFilePath = referenceFilePath;
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }

    public void setOutputFilePath(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    public List<String> getTransformationRules() {
        return transformationRules;
    }

    public void setTransformationRules(List<String> transformationRules) {
        this.transformationRules = transformationRules;
    }

    /**
     * Validates the configuration properties after they are set.
     */
    @PostConstruct
    public void validate() {
        if (inputFilePath == null || inputFilePath.isEmpty()) {
            throw new IllegalArgumentException("Input file path must be set");
        }
        if (referenceFilePath == null || referenceFilePath.isEmpty()) {
            throw new IllegalArgumentException("Reference file path must be set");
        }
        if (outputFilePath == null || outputFilePath.isEmpty()) {
            throw new IllegalArgumentException("Output file path must be set");
        }
        // Additional validation can be added as needed
    }
}
