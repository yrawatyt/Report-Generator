package com.example.reportgenerator.config;

import com.example.reportgenerator.service.ReportGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class SchedulingConfig {

    private static final Logger logger = LoggerFactory.getLogger(SchedulingConfig.class);

    @Autowired
    private ReportGenerationService reportGenerationService;

    /**
     * Schedules the report generation using a cron expression defined in the configuration.
     */
    @Scheduled(cron = "${report.generation.cron}")
    public void scheduleReportGeneration() {
        try {
            reportGenerationService.generateReport();
            logger.info("Report generation scheduled successfully.");
        } catch (Exception e) {
            logger.error("Error occurred during scheduled report generation", e);
        }
    }
}
