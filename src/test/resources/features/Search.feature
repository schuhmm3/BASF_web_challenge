@search
Feature: Search
  As a registered user
  I want to perform a search
  In order to read the abstracts

  Scenario Outline: Search word
    Given a logged in user
    When performing a search with the following word <query>
    Then each abstract of the top <nRows> search results contains the word <query>
    Examples:
      | query    | nRows |
      | propylen | 3     |