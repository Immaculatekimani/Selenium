# Selenium Automation Project
## Overview
This project is a demonstration of automated testing using Selenium WebDriver for Java web application testing. The application used in this case is the attendance 
web app in my repository.

## Prerequisites
- Java 11 or higher installed
- Maven installed
- Chrome WebDriver installed and configured
- Access to the web application under test (assuming it's running locally on port 8080)
## Setup
- Clone this repository to your local machine. 
- Clone the attendance repository in my account. You can use your own web app and change the specifications.
- Ensure you have Java and Maven installed. 
- Make sure Chrome WebDriver for your chrome version is downloaded and you have specified the path in the main file.
- Run mvn clean install to download dependencies and build the project.
## Usage
1. Update the Main.java file with appropriate web elements and actions according to your application.
2. Run the Main.java file to execute the automated tests.
3. View the console output for test results and any error messages.
## Dependencies
**Selenium WebDriver:** Used for automating web application testing.

**JUnit Jupiter:** Testing framework for writing and running tests.
## Project Structure
- **pom.xml:** Maven configuration file specifying project dependencies and settings.
- **src/main/java:** Contains Java source code.
- **src/test/java:** Contains test classes.