# Report Generator

## Overview

Report Generator is a robust Spring Boot application designed to process large CSV files, apply configurable transformations, and generate reports. It supports both scheduled and on-demand report generation via REST API, efficiently handling files up to 1GB in size. The application is built with extensibility in mind, allowing for future support of different file formats and transformation rules.

## Features

- CSV file ingestion for input and reference data
- Configurable data transformation rules
- Scheduled report generation
- On-demand report generation via REST API
- Scalable architecture to handle large files (up to 1GB)
- Extensible design for future support of different file formats (Excel, JSON, etc.)

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- Spring Boot 2.5.x or later

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── reportgenerator/
│   │               ├── config/
│   │               │   ├── ReportConfig.java
│   │               │   └── SchedulingConfig.java
│   │               ├── controller/
│   │               │   └── ReportController.java
│   │               ├── model/
│   │               │   ├── InputData.java
│   │               │   ├── OutputData.java
│   │               │   └── ReferenceData.java
│   │               ├── service/
│   │               │   ├── FileIngestionService.java
│   │               │   ├── ReportGenerationService.java
│   │               │   └── TransformationService.java
│   │               └── ReportGeneratorApplication.java
│   └── resources/
│       └── application.properties
└── test/
    ├── java/
    │   └── com/
    │       └── example/
    │           └── reportgenerator/
    │               ├── config/
    │               │   ├── ReportConfigTest.java
    │               │   └── SchedulingConfigTest.java
    │               ├── controller/
    │               │   └── ReportControllerTest.java
    │               └── service/
    │                   ├── FileIngestionServiceTest.java
    │                   ├── ReportGenerationServiceTest.java
    │                   └── TransformationServiceTest.java
    └── resources/
        ├── test-input.csv
        └── test-reference.csv
```

## Configuration

Configure the application in the `application.properties` file:

```properties
report.input-format=csv
report.output-format=csv
report.input-file-path=/path/to/input.csv
report.reference-file-path=/path/to/reference.csv
report.output-file-path=/path/to/output.csv
report.generation.cron=0 0 1 * * ?  # Run at 1 AM every day
```

## Building the Project

To build the project, run:

```bash
mvn clean install
```

## Running the Application

To run the application, use:

```bash
java -jar target/report-generator-1.0.0.jar
```

Or with Maven:

```bash
mvn spring-boot:run
```

## API Endpoints

- Generate Report: `POST /api/reports/generate`

## Testing

To run the tests, execute:

```bash
mvn test
```

## Future Enhancements

- Support for Excel and JSON file formats
- More sophisticated transformation rules
- Performance optimizations for processing very large files
- User interface for configuring transformation rules and schedules

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct and the process for submitting pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

---
