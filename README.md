[![Build Status](https://travis-ci.org/ddubson/angular4-springboot-boilerplate.svg?branch=master)](https://travis-ci.org/ddubson/angular4-springboot-boilerplate)

# Angular 4 / Spring Boot boilerplate application

This project seeks to set up a jumping off point for an Angular 4 and
Spring Boot project.

Additional tools that are involved are:

- Fluentlenium (Acceptance testing)
- Jasmine test framework
- Karma test runner
- Gradle NodeJS plugin (for executing NPM tasks via Gradle)

## Running the Application

```bash
./gradlew npmInstallGlobals npmBuild bootRun
```

## Executing the tests

```bash
./gradlew npmTest test
```

> npmInstallGlobals needs to be run only once

## Spring Boot

Source File directory:
```bash
src/main/java/com/ddubson/
```

Test File directory
```bash
src/test/java/com/ddubson/
```

## Angular 4

Source File directory:`webapp/src/`
Root src file: `webapp/src/main.ts`
Root Angular App Module: `webapp/src/app.module.ts`

Test File directory: `webapp/test/`
Root test file: `webapp/test/test_index.js`

Typescript configuration: `webapp/tsconfig.json`
Karma configuration: `webapp/test/karma.conf.js`
