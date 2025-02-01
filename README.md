# SpiceJet Flight Booking Automation
This project automates the flight booking process for SpiceJet using Cucumber with TestNG for BDD-style testing, Selenium WebDriver for browser automation, and Rest Assured for API testing. It provides a set of automated tests for validating flight booking functionalities.

Project Structure
features/: Contains Gherkin .feature files that describe the test scenarios in BDD format.
step_definitions/: Contains Java classes with step definitions corresponding to the Gherkin steps.
pages/: Implements Page Object Model (POM) design pattern to define web elements and interactions.
utilities/: Contains utility classes, including JsonUtility for reading and updating JSON files.
test_runners/: Contains test runners to execute Cucumber tests via TestNG.
data/: Contains JSON files for test data used in scenarios.
Features
Flight Booking: Allows users to automate flight booking by selecting travel options (round trip, country, dates, passengers, currency).
API Automation: Verifies API endpoints and responses using Rest Assured.
Integration with Jenkins and Docker: Supports CI/CD pipelines to run the tests automatically in a controlled environment.
Technologies Used
Selenium WebDriver: For browser automation.
Cucumber & TestNG: For BDD-style testing and execution.
Rest Assured: For API testing and validation.
Jenkins: For continuous integration and automated testing.
Docker: For containerizing the test execution environment.
WebDriverManager: To automatically manage the browser driver binaries.
JSON.simple: For handling JSON data in test cases.
Prerequisites
Ensure the following tools are installed before running the tests:

Java 8+
Maven
Git
Docker (if using Docker for containerized execution)
Jenkins (for CI/CD integration)
