[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

# test-automation-framework
A simple test automation framework which provides the following features:

- TestNG based framework
- Integrated with [Allure Report](https://allurereport.org/)

## Pre-requisites

- JDK 11+ _(Optional - **SDKMAN** - to manage multiple versions of Java)_ [SDKMAN](https://sdkman.io/install)
- Maven > 3.x.x onwards
- Any IDE for development (IntelliJ/Eclipse,..)
- Node Js (> 16.x onwards) _(Optional - **NVM** - to manage multiple versions of NodeJs)_ [nvm](https://github.com/nvm-sh/nvm)
- [Allure CommandLine](https://www.npmjs.com/package/allure-commandline)

## Clone and Build from Source

Build from the Command Line
To compile, test, and build

1. Clone the repository from GitHub:
```bash
$ git clone git@github.com:DineshKuppan/test-automation-framework.git
$ cd test-automation-framework
```
2. The project uses [Maven](http://maven.apache.org/) to build:
```
$ mvn clean package -DskipTests
```

Alternative

Install the `test-automation-framework` in you local Maven repository (`$HOME/.m2` or `$USER_PROFILE/.m2`) directory.

```bash
$ mvn clean install -DskipTests
```
## Running from the Command Line

```bash
mvn clean test -Dtest=com.bytes2gram.framework.test.CalculatorTest
```


## How to view allure report ?

**Note:**  Install the allure commandline to generate and view the report in browser
```bash
allure serve target/allure-results

```