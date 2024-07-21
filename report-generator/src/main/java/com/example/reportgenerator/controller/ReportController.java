package com.yourcompany.reportgenerator.controller;

import com.yourcompany.reportgenerator.service.ReportGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    private ReportGenerationService reportGenerationService;

    /**
     * Endpoint to trigger report generation.
     *
     * @return ResponseEntity with the status of the report generation.
     */
    @PostMapping("/generate")
    public ResponseEntity<String> generateReport() {
        try {
            logger.info("Report generation request received.");
            reportGenerationService.generateReport();
            logger.info("Report generated successfully.");
            return ResponseEntity.ok("Report generated successfully");
        } catch (Exception e) {
            logger.error("Error generating report", e);
            return ResponseEntity.internalServerError().body("Error generating report: " + e.getMessage());
        }
    }
}
