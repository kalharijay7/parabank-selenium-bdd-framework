# 🏦 Parabank Selenium BDD Framework  

[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://www.oracle.com/java/)
[![Selenium](https://img.shields.io/badge/Selenium-4.0-green.svg)](https://www.selenium.dev/)
[![Cucumber](https://img.shields.io/badge/Cucumber-BDD-brightgreen.svg)](https://cucumber.io/)
[![TestNG](https://img.shields.io/badge/TestNG-Testing-orange.svg)](https://testng.org/doc/)
[![Log4j](https://img.shields.io/badge/Log4j-Logging-yellow.svg)](https://logging.apache.org/log4j/)
[![Allure](https://img.shields.io/badge/Allure-Reports-red.svg)](https://docs.qameta.io/allure/)
[![Jenkins](https://img.shields.io/badge/CI-CD%20with%20Jenkins-blue.svg)](https://www.jenkins.io/)
[![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg)]()
[![Coverage](https://img.shields.io/badge/coverage-90%25-success.svg)]()

---

## 📘 Overview  

This repository contains a **Data-Driven BDD Test Automation Framework** developed in **Java** using **Selenium WebDriver**, **Cucumber**, and **TestNG** for the [Parabank Demo Application](https://parabank.parasoft.com/parabank/).  

It follows the **Page Object Model (POM)** design pattern for scalability and supports **data-driven testing**, **logging**, and **reporting** through **Log4j** and **Allure Reports**. The framework is designed to be easily extensible, maintainable, and CI/CD-ready via **Jenkins**.  

---

## 🚀 Key Features  

- 🧩 **Page Object Model (POM)** design for modularity and reusability  
- 🥒 **BDD with Cucumber** for human-readable test cases  
- 📊 **Data-Driven Testing** with externalized test data (CSV/Excel/JSON)  
- 🧠 **Centralized Logging** via Log4j2  
- 📈 **Allure Reports** integration for detailed reporting  
- ⚙️ **TestNG** runner for flexible test configuration  
- 🔁 **CI/CD integration** with Jenkins  
- 🌐 Cross-browser and environment support  

---

## 📁 Project Structure  

```
├── src
│ ├── main
│ │ ├── java
│ │ │ ├── base/ # Base test setup (driver, config)
│ │ │ ├── pages/ # Page Object classes
│ │ │ ├── utils/ # Utilities (data readers, config manager)
│ │ │ └── helpers/ # Reusable helper methods
│ │ └── resources
│ │ ├── config.properties # Application configuration
│ │ └── testdata/ # External data files
│ └── test
│ ├── java
│ │ ├── stepDefinitions/ # Step definitions for Cucumber
│ │ ├── runners/ # Cucumber + TestNG runners
│ │ └── hooks/ # Before/After hooks
│ └── resources
│ └── features/ # Cucumber feature files
│
├── pom.xml # Maven dependencies
├── log4j2.xml # Logging configuration
├── Jenkinsfile # Jenkins pipeline configuration (optional)
└── README.md
```

---

## ⚙️ Setup Instructions  

### 1️⃣ Clone the Repository  
```bash
git clone https://github.com/<your-username>/parabank-selenium-bdd-framework.git
```
### 2️⃣ Import into IDE
Open the project in IntelliJ IDEA or Eclipse as a Maven project.

### 3️⃣ Install Dependencies
```bash
mvn clean install
```

### 4️⃣ Run Tests
- Run via TestNG
```bash
mvn test
```
- Run with specific Cucumber tags
```bash
mvn test -Dcucumber.filter.tags="@Smoke"
```

---

## 🧾 Reporting
### 📊 Generate Allure Reports
Run the following command after test execution:
```bash
mvn allure:serve
```
This will automatically open an interactive Allure Report in your browser.

Alternatively, to generate the static report:
```bash
mvn allure:report
```
Allure results will be stored in:
```bash
/target/allure-results
```
---

## 🧠 Logging
- Configured via **Log4j2** (`log4j2.xml`) 
- Logs are generated in the /logs directory with timestamped filenames.
- Each test run maintains a separate log file for easy traceability.

---
## 🔄 CI/CD Integration with Jenkins
1. Install Maven and Allure Jenkins Plugin on your Jenkins server.
2. Create a Freestyle or Pipeline project.
3. Configure GitHub SCM → add your repository URL.
4. Add the build step:
```bash
mvn clean test
```
5. Post-build action (optional): Publish Allure Report.
6. (Optional) Add a webhook in GitHub → Jenkins for auto-builds on push.
💡 For a pipeline setup, use the included Jenkinsfile or create your own declarative pipeline with mvn clean test and mvn allure:report.

---
## 🧪 Example Feature File
```gherkin
Feature: Login Functionality

  Scenario: Valid user logs into Parabank
    Given User is on the Parabank login page
    When User enters valid credentials
    And Clicks on the login button
    Then User should be redirected to the Accounts Overview page
```
---
## 🧭 Future Enhancements
- 🔁 Parallel execution using TestNG or Selenium Grid
- 🐳 Dockerized execution for consistent environments
- ☁️ Integration with BrowserStack or LambdaTest
- 📬 Email notification for test reports
- 📦 Enhanced data-driven layer using Apache POI or JSON

---

## 👨‍💻 Author
Kalhari Jayasinghe – Quality Assurance Engineer | Developer
- Practicing automated testing frameworks and UI testing for web applications
- Open to freelance/portfolio projects in test automation

---

⭐ If you found this framework useful, give it a star on GitHub!
It helps others discover the project and motivates further enhancements.
