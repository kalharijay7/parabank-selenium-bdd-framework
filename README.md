# NopCommerce Selenium Framework

This repository contains a **Selenium + Java automation framework** for the [nopCommerce demo site](https://demo.nopcommerce.com/).  
It demonstrates **automation best practices** using the **Page Object Model (POM)**, TestNG, Maven, and utility classes for configuration and data management.

---

## 🔹 Features
- **Page Object Model (POM)** for scalable automation  
- **Configurable settings** via `config.properties`  
- **Data-driven testing** using Excel files  
- **TestNG framework** with structured test cases  
- **Reports**: ExtentReports / TestNG reports  
- **Reusable utilities**: WebDriver setup, waits, Excel reader, config reader  
- **Organized structure**: Pages, Tests, Utils, Base classes  

---

## 🔹 Project Structure

src/
├── main/java/com/nopcommerce/
│ ├── base/ # BasePage, BaseTest
│ ├── pages/ # Page objects
│ │ └── account/ # My Account child pages
│ └── utils/ # ConfigReader, ExcelReader, DriverFactory
└── test/java/com/nopcommerce/testcases/
├── auth/ # Login, Register tests
├── shopping/ # Product search, Cart, Checkout tests
└── account/ # Orders, Addresses, Reward Points tests
config/
└── config.properties # Base URL, browser, credentials
test-output/ # Auto-generated reports


---

## 🔹 Prerequisites
- Java 8+  
- Maven 3+  
- ChromeDriver/GeckoDriver in PATH (or managed by WebDriverManager)  
- Eclipse IDE (or IntelliJ/VS Code)  

---

## 🔹 How to Run Tests

### Using Eclipse
1. Import project → `File → Import → Existing Maven Project`.  
2. Ensure `config.properties` has correct settings (browser, URL, credentials).  
3. Right-click on a test class → `Run As → TestNG Test`.  

### Using Maven
```bash
mvn clean test

---
### Configuration

Example config.properties:
baseUrl=https://demo.nopcommerce.com/
browser=chrome
implicitWait=10
explicitWait=20
headless=false
username=testuser@example.com
password=Test@123

🔹 Tools & Technologies

Java
Selenium WebDriver
TestNG
Maven
Apache POI (Excel)
ExtentReports / TestNG Reports

🔹 Contribution

This is a personal learning project / portfolio repo. Contributions are welcome for improvements, but please fork and test before submitting pull requests.

🔹 Author

Kalhari Jayasinghe – QA Automation Engineer
[GitHub Profile](https://github.com/kalharijay7)
