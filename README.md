# Connected-Cities
application determines if two cities are connected. Two cities are considered connected if there’s a series of roads that can be traveled from one city to another.

A rest api is exposed which determines the possible path between two cities. If path exists then return "Yes" or "No" in response

# Technologies

Spring Boot 2.x,
Java 1.8,
Maven,
Mockito for Unit testing.

# Implementation Steps

After analyzing the requirement, it is considered to use collection to compute the path between two cities where they are not directly connected

    city.txt - Given a text file consists of pair of cities in each line with comma(,) separated.
    CityUtil.java - Config file reads the textfile and places all the cities in Map collection 
    CityPairController.java - An API is exposed through a rest controller web method - isConnected() which takes 2 inputs origin and destination as Query Parameters
    CityPairService.java - A service class is invoked from controller which process the inputs and compute the path of the cities.
    Endpoints - test in postman.
        http://localhost:8080/connected?origin=Boston&destination=Newark
        http://localhost:8080/connected?origin=New York&destination=Philadelphia
        http://localhost:8080/connected?origin=Philadelphia&destination=Trenton

Unit Testing

Test classes package.
Unit testing carried through Mockito framework, allows the creation of unit tests for the purpose of test-driven development (TDD). Test cases are cover Only controller class for this project. Unit Test classes can run through maven build command or can be execute directly from test class from eclipse editor.

    />mvn clean install

all the test cases passed.
Build Status

    Success

# Code repository in GITHUB
    https://github.com/khaleelmys/Connected-Cities

# Installation

    Please clone above git repo or download the project zip file from github.
    NO further config or settings needed.
    Build the project from terminal \Connected-Cities-master> mvn clean install
    Shows BUILD SUCCESS on project compilation and test classes pass through.
    To execute the application please run below command from terminal \Connected-Cities-master> java -jar target/Connected-Cities-master-0.0.1-SNAPSHOT.jar
    Server will up running on 8080
    Tomcat started on port(s): 8080 (http) with context path
    
# Screenshots For Proof

    Screenshots - screenshots of code snippet, unit test cases execution and api calls through postman are recorded in git document.
