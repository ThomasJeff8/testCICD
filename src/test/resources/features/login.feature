@Login
Feature: As user I want to login

  Scenario: POST - As a user I success to login with valid data
    Given user set endpoint for login
    When user send POST HTTP request with valid data
    Then user see status code 201
    And get valid data

  Scenario: POST - Verify As a user i want to login with invalid data username
    Given user set endpoint for login
    When user send POST HTTP request with invalid data username
    Then user see status code 401
    And user get error message "username, or email not found"

  Scenario: POST - Verify As a user i want to login with invalid data email
    Given user set endpoint for login
    When user send POST HTTP request with invalid data email
    Then user see status code 401
    And user get error message "username, or email not found"

  Scenario: POST - Verify As a user i want to login with invalid data password
    Given user set endpoint for login
    When user send POST HTTP request with invalid data password
    Then user see status code 401
    And user get error message "username, or email not found"
