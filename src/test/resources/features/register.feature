@Register
Feature: As user i want to create account So that i can login and see home page

  Scenario: POST - As a user I success to create account with valid data
    Given user set endpoint for register
    When user send create account with valid data
    Then user see status code 201 after send register
    And user see new detail account

  Scenario: POST - Register an account with the data already registered
    Given user set endpoint for register
    When user send create account with data already registered
    Then user see status code 500 after send register
    And get error message "user has been added"

  Scenario: POST - Register an account with a short password
    Given user set endpoint for register
    When user send create account with a short password
    Then user see status code 400 after send register
    And get error message "password is too short"

  Scenario: POST - Register an account with a password that does not contain special characters
    Given user set endpoint for register
    When user send create account with a password that does not contain special characters
    Then user see status code 400 after send register
    And get error message "password does not contain a special character"

  Scenario: POST - Register an account with a password that does not contain number character
    Given user set endpoint for register
    When user send create account with with a password that does not contain number character
    Then user see status code 400 after send register
    And get error message "password does not contain a number character"