# Demo Project

This is a simple demo Spring Boot web application that calls the GitHub API and displays a list of projects.

## Overview

The application demonstrates a basic Spring MVC web application with the following components:

- `DemoApplication` - The main Spring Boot application class 
- `Project` - A model class that maps GitHub project JSON responses to Java objects
- `ProjectsController` - Calls GitHub API and returns list of Project objects
- `WelcomeController` - Renders a welcome page with link to view projects
- `welcome.html` - Thymeleaf template that displays the welcome page
- `application.properties` - Configures defaults like app name and logging  
- Test class - Simple test that context loads

When the app runs, the `/` route renders the `welcome.html` page. This page has a link to the `/projects` route.

The `/projects` route calls the GitHub API, parses the JSON response to `Project` objects, and returns the list of projects.

## Building and Running

To build:

```
./mvnw clean package 
```

To run: `java -jar target/demo-0.0.1-SNAPSHOT.jar`
