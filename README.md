
# Magento Store Automation Project

## Overview

This project is an automation framework for testing a Magento store. It is built using Java and Selenium WebDriver, with TestNG as the testing framework. The project utilizes the Page Object Model (POM) design pattern and integrates with Allure Report and Extent Report for detailed reporting. Additionally, it includes Cucumber for Behavior-Driven Development (BDD) and supports data-driven testing through Excel files using TestNG's `DataProvider`. The framework is configured to run tests in para...

## Features

- **Page Object Model (POM):** Organized structure that helps in maintaining the code and reducing redundancy.
- **Parallel Testing:** Executes multiple tests concurrently, reducing overall execution time.
- **Data-Driven Testing:** Uses Excel files to supply test data.
- **BDD with Cucumber:** Supports writing test cases in a human-readable format.
- **Reporting:**
  - **Allure Report:** Provides detailed and interactive test reports.
  - **Extent Report:** Offers another layer of reporting with rich insights and visuals.
- **Configuration Management:** Properties file is used to manage environment configurations.

## Technologies Used

- **Java:** Core programming language used for developing the framework.
- **Selenium WebDriver:** For automating browser actions.
- **TestNG:** Testing framework that supports annotations, parallel testing, and more.
- **Cucumber:** For writing BDD-style test cases.
- **Allure Report:** To generate detailed test reports.
- **Extent Report:** For advanced reporting.
- **Apache POI:** To read and write Excel files for data-driven testing.
- **Maven:** Project management and build tool.

## Project Structure

```
MagentoStore
├── allure-report
├── allure-results
├── Screenshots
├── Download
├── Upload
├── extentreports
│   └── ExtentReport.html
├── logs
│   └── app.log
├── ParallelBrowser.xml
├── RegressionWithCrossBrowser.xml
├── RegressionWithExtenReport.xml
├── RegressionWithTestNGL.xml
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── magento
│   │               ├── helpers
│   │               │   └── ProductHelper.java
│   │               ├── Pages
│   │               │   ├── BasePage.java
│   │               │   ├── Footer.java
│   │               │   ├── ForgotPasswordPage.java
│   │               │   ├── Header.java
│   │               │   ├── LandingPage.java
│   │               │   ├── LoginPage.java
│   │               │   ├── MainNavbar.java
│   │               │   └── RegisterPage.java
│   │               └── Utils
│   │                   ├── ConfigReader.java
│   │                   ├── EventReporterSelenium.java
│   │                   ├── ExcelUtils.java
│   │                   ├── ReadExcelData.java
│   │                   └── WindowManager.java
│   └── test
│       ├── java
│       │   └── com
│       │       └── magento
│       │           ├── Cucumber
│       │           │   ├── Features
│       │           │   │   └── Login.feature
│       │           │   ├── Runner
│       │           │   │   └── TestRunner.java
│       │           │   └── Steps
│       │           │       └── LoginSteps.java
│       │           ├── DataProvider
│       │           │   ├── LoginDataProvider.java
│       │           │   └── RegistrationDataProvider.java
│       │           └── TestCases
│       │               ├── BaseTest.java
│       │               ├── ExtentReportManager.java
│       │               ├── ForgotPasswordTest.java
│       │               ├── LandingTest.java
│       │               ├── LoginTest.java
│       │               ├── MainNavbarTest.java
│       │               ├── MyListenerTestNG.java
│       │               ├── RegisterTest.java
│       │               └── TopsMenTest.java
│       └── resources
│           ├── config.properties
│           └── log4j2.xml
└── TestData
     └── TestData.xlsx
```

## Getting Started

### Prerequisites

- **Java 8 or higher**
- **Maven**
- **Selenium WebDriver**
- **TestNG**
- **Allure Commandline**
- **Extent Reports**

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/magento-automation.git
   ```

2. Navigate to the project directory:
   ```bash
   cd magento-automation
   ```

3. Install dependencies:
   ```bash
   mvn clean install
   ```

### Running Tests

- To run all tests:
  ```bash
  mvn test
  ```

- To run tests with Allure report:
  ```bash
  mvn clean test allure:report
  ```

- To generate an Extent Report:
  Configure the extent-config.xml file in the `resources` folder and run your tests. The report will be generated in the specified output directory.

### Reports

- **Allure Report:**
  After running tests, generate the report using:
  ```bash
  allure serve
  ```

- **Extent Report:**
  Extent Reports are automatically generated in the `output/extent-reports` directory.

## Contributing

Feel free to submit issues or pull requests. Contributions are welcome!

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
