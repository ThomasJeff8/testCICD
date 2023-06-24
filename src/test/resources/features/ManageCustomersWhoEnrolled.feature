@ManageCustomers
Feature: As admin I want to see all customers who enrolled in the course

  Scenario: GET - I want to see all customers who enrolled in the course using admin token
    Given user set endpoint for get customers who enrolled in the course
    And login to get token
    When user send GET HTTP request and token for get customers who enrolled in the course
    Then user see status code 200
    And get all customers who enrolled in the course data

  Scenario: GET - I want to see all customers who enrolled in the course using normal token
    Given user set endpoint for get customers who enrolled in the course
    And login to get token using normal user
    When send GET HTTP request and token user for get customers who enrolled in the course
    Then error status code 401