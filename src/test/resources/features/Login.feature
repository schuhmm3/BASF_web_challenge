@login
Feature: Login
  As a registered user
  I want to be able to login
  In order to perform some searchs

#  According to the scenario description I registered manually and I'm using these credentials for login
  Scenario: Log in for a registered user
    Given a registered user
    When They login with valid credentials
    Then They will land into the QKnows QA page

