# RestAssured API Testing Project

## Project Description
This project demonstrates API testing using the **RestAssured** library in Java. It includes various test cases for validating RESTful web services.


## Features
- Automated API testing with **RestAssured**
- Support for GET, POST, PUT, DELETE requests
- JSON payload handling
- Response status code, headers, and body validations
- Data-driven testing using external data files
- Integration with TestNG for test execution

## Technologies Used
- **Java**: Programming language
- **RestAssured**: API testing library
- **TestNG**: Testing framework
- **Maven**: Dependency management and build tool
- **JSON** / **XML**: Payload handling
- **Git**: Version control

## Folder Structure
```
|-- src
|   |-- test
|       |-- java
|           |-- day01
|               |-- TestOne.java
|       |-- resources
            |-- exampleText.txt
|-- pom.xml
|-- README.md
```

## Prerequisites
- **Java Development Kit (JDK)** (version 8 or later)
- **Maven** installed on your system
- A supported **IDE** (e.g., IntelliJ IDEA, Eclipse)

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd <project-folder>
   ```
3. Install dependencies:
   ```bash
   mvn clean install
   ```
## How to Run Tests
### Using Maven
1. Run all tests using Maven:
   ```bash
   mvn test
   ```
   Or run specific tests using TestNG:
   ```bash
   mvn test -Dtest=<TestClassName>
   ```

### Using TestNG in IDE
1. Open the project in your preferred IDE.
2. Locate the `testng.xml` file.
3. Right-click on the `testng.xml` file and select **Run 'testng.xml'** to execute all tests.




