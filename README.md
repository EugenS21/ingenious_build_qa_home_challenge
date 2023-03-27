# Ingenious Build Automation Project

Ingenious Build Automation Project is a Java-based project that is designed to provide automation testing capabilities
for both UI and API tests. With this project, you can easily create and run automated tests for your web application and
APIs, which can save you time and improve the quality of your software.

## Project Structure

Ingenious Build Automation Project consists of 5 modules to split the functionality into. I made this decision because
modularization brings some advantages:

* **Code organisation** - it's easier to find the code and manage it (for example, if you need to add some code related
  to ui - you only need to locate the module that contains ui functionality inside).
* **Code reusability** - we can have a common module to store some utils (for example, converters, spring beans) that
  are required in different modules, avoiding duplication of code,
* **Dependencies management** - by having multiple modules, we can avoid conflict between libraries or versions and have
  a more specific dependency management (for example, in case of api tests - I don't need to have dependency on
  webclient).
* **Better versions control** - let's say I want to do a refactor in a module, instead of breaking everything in child
  modules that depends on it, I can create a new version of module that will contain the changes - the child modules
  won't be affected as they are using an old version.

![Maven modules project structure](/mnt/bffb71e8-12bd-4a95-95d8-fa3db40f3217/Projects/Experiments/ingenious_build_qa_home_challenge/dependency-tree.png "Project structure")

### Modules

- **qa_home_challenge** - parent module, contains properties of all the project, plugins and dependencies;
- **common-tools** - stores functionality and dependencies shared across the project
- **testing-components-core** - contains functionality, properties and dependencies shared across test modules
- **web-automation-core** - provides core code for the ui module: locators, web objects, utilities;
- **web-automation** - contains tests scenario, step implementation and other classes involved in ui testing;
- **api-automation-core** - provides core code for the api module: endpoints, web client properties, services;
- **api-automation** - contains tests scenario, step implementation and other classes involved in api testing.

## Advantages of Java for Automation Testing

Java is a popular programming language that is widely used for automation testing because of its many advantages:

- **Platform independence:** code can run on any platform, which makes it easier to develop and test.

- **Object-oriented programming:** allows easy code re-usability and makes it easier to maintain and update.

- **Large community support:** there are plenty of resources and libraries available for automation testing.

## Criteria for choosing libraries

I selected to work with some popular libraries:

- **Spring Boot Framework** - for autoconfiguration, dependency injection, properties reading;
- **TestNG** - it's a popular testing framework, it can be easy to integrate with spring and cucumber;
- **Cucumber** - to write tests in a clear and concise manner that describes the behavior of the system in plain
  English. This can help ensure that everyone on the team has a shared understanding of the requirements and can help
  reduce ambiguity in the tests.
- **Selenium** - it's a popular framework to interact with ui devices: browsers, mobiles;
- **webdrivermanager** - to easy manage web driver initialization and browsers binary download;
- **Lombok** - to generate boilerplate code (setters, getters, constructors...) automatically;
- **Vavr** - to make the code more concise and readable;
- **Spring WebClient** - it offers a functional API, which allows to write clean and concise code for making HTTP
  requests, supports non-blocking I/O, and it's easy to integrate with Spring framework;
- **Model Mapper** - a tool to auto-map objects of a type to another;
- **Apache Commons** - contains a rich set of useful methods for working with strings, collections and many more;
- **Allure** - provides rich and detailed reports, it's easy to customize;
- **Faker** - provides an api with various random fake data: name, zip codes, addresses.

## Prerequisites

Before you can use My the framework, you will need to install the following software:

* **Java 17**: The Project is built on Java 17, so you will need to install this version of Java or a more recent
  version in order to run the project. You can download it from the official Java
  website: https://www.oracle.com/java/technologies/downloads/#java17
* **Maven 3.6.3**: My Project is built using Maven, so you will need to install this version of Maven or a more recent
  version in order to build and run the project. You can download it from the official Maven
  website: https://maven.apache.org/download.cgi

Once you have installed these prerequisites, you should be ready to start using the framework.

## Usage

The framework was configured to run tests during the `verify` phase of the Maven build lifecycle. This ensures that all
tests are executed and any failures are caught before the project is deployed or released.

To make running of tests individualized by category type, 3 maven profiles were created: **ui, api, all**.

To run tests execute the following command from the root level of the project, after replacing **<type>** with the type
of tests you want to run:

`mvn clean verify -P <type>`

There is also the possibility to run only some scenario that are annotated with a custom cucumber tag, for example, to
run only scenario annotated with @demo use:

`mvn clean verify -P <type> -Dcucumber.filter.tags=@demo`

Tests can be ran with different browsers: CHROME, FIREFOX, EDGE, by running:
`mvn clean verify -P ui allure:aggregate -Dapplication.driver.type=<type>`

## Results

To generate a testing report use:

`mvn allure:aggregate`

The command from bellow will aggregate all the reports from ui and api module into a single one available inside *
*%dir%/ingenious_build_qa_home_challenge/allure-report/**. Open **index.html** to view the report.

## How to develop new tests

UI and API tests shared almost the same structure when it comes to writing tests. You can add new feature files inside *
*src/test/resources/features**.
Step definitions are stored inside **steps** package, under **src/test/java/** and are split by type in
actions/assertions packages to store actions and assertions steps, make sure you follow this convention when adding new.

### Web

To add new

### API

