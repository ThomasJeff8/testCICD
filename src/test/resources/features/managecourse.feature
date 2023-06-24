@ManageCourse
Feature: As admin I want to see all course

  Scenario: GET - As a admin I want to see all course
    Given user set endpoint for get course
    And login as admin to get token
    When user send GET HTTP request
    Then user see status code 200
    And get all course show up

  Scenario: GET - As a admin I want to see all course using normal user
    Given user set endpoint for get course
    And login as user to get token
    When user send GET HTTP request using normal token
    Then user see status code 401

  Scenario: GET - As a admin I want to see specific course
    Given user set endpoint for get specific course "11349b5009444dd585fcdc4ee9fa5ca0"
    And login as admin to get token
    When user send GET HTTP request
    Then user see status code 200


  Scenario: GET - As a admin I want to successful get who courses enrolled
    Given user successful get who courses enrolled
    And login as admin to get token
    When user send GET HTTP request
    Then user see status code 200

  Scenario: GET - As a admin I want to successful get course resumes
    Given user successful get course resumes
    And login as admin to get token
    When user send GET HTTP request
    Then user see status code 200
