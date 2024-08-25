
# **🚀 POM (Page Object Model) Architecture in Appium with Java**

<table>
  <tr>
    <td>
      <p>
        In the context of Appium and Java, the Page Object Model (POM) architecture is a design pattern that helps to create a clear structure for your test automation projects. The architecture is typically divided into several layers, each with specific responsibilities. Below is a general outline of the POM architecture, along with the purpose of each component.
      </p>
    </td>
    <td>
      <img src="https://media1.giphy.com/media/v1.Y2lkPTc5MGI3NjExeDQyeWQxdmp2c2U5bWZ3Nmh0MjU5Z2YyeWk4YmZzN2drMzF4OWN0ZCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/SWoSkN6DxTszqIKEqv/giphy.webp" alt="POM Animation" width="900"/>
    </td>
  </tr>
</table>

---

## **📁 Project Structure**

```
project-root
│
├── src
│   ├── main
│   │   └── java
│   │       └── com.projectname.pages (Page Objects)
│   │           ├── Page01.java
│   │           ├── Page02.java
│   │           └── Page03.java
│   │       └── com.projectname.utils (Utility classes)
│   │           ├── DriverManager.java
│   │           ├── TestUtil.java
│   │           └── ConfigReader.java
│   ├── test
│       └── java
│           └── com.projectname.tests (Test Cases)
│               ├── Test01.java
│               ├── Test02.java
│               └── Test03.java
│           └── com.projectname.base (Base Test Class)
│               └── BaseTest.java
│
├── resources
│   ├── config.properties
│   └── log4j.properties
│
├── pom.xml (Maven configuration file)
└── testng.xml (TestNG configuration file)
```

---

## **📝 Explanation of Each Component**

### 1. **Page Objects (src/main/java/com.projectname.pages)**
This package contains classes that represent the pages of the application under test. Each class contains the locators and methods to interact with the elements on that particular page.

### 2. **Utility Classes (src/main/java/com.projectname.utils)**
Utility classes are helpers that provide common functions used across different parts of the project.

- **DriverManager.java**:
  - Responsible for setting up and managing the WebDriver instance.
  - Methods to initialize and quit the driver, manage browser configurations, etc.

- **TestUtil.java**:
  - Contains utility methods for common actions like taking screenshots, waiting for elements, or handling alerts.

- **ConfigReader.java**:
  - Reads configuration settings from the `config.properties` file.
  - Provides methods to fetch environment-specific data like URLs, credentials, etc.

### 3. **Test Cases (src/test/java/com.projectname.tests)**
This package contains the actual test cases that will be executed. Each test class corresponds to a particular feature or a set of related functionalities.

### 4. **Base Test Class (src/test/java/com.projectname.base)**
This package contains the base class that all test classes extend. It provides common setup and teardown methods for tests.

- **BaseTest.java**:
  - Contains methods annotated with `@BeforeSuite`, `@BeforeTest`, `@AfterTest`, and `@AfterSuite`.
  - Sets up the WebDriver, loads the configuration, and quits the driver after tests are completed.

### 5. **Configuration Files**
Configuration files store settings and data that can be used throughout the project.

- **config.properties**:
  - Contains key-value pairs for configuration settings like base URLs, browser types, timeout values, etc.

- **log4j.properties**:
  - Configures logging for the project. Defines how logs will be captured and where they will be stored.

### 6. **Maven Configuration File (pom.xml)**
This file is used to manage project dependencies, plugins, and build configurations.

- **pom.xml**:
  - Defines dependencies like Selenium, Appium, TestNG, etc.
  - Configures plugins for reports, build lifecycle, etc.

### 7. **TestNG Configuration File (testng.xml)**
This file is used to define test suites, groups, parameters, and execution sequences.

- **testng.xml**:
  - Specifies which tests to run, the order of execution, and other TestNG settings like parallel execution.

---

**🌟 Feel free to fork, clone, and contribute!**
