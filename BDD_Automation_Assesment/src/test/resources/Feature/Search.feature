Feature: Search feature in TutorialNinja website

  Description: As a user, I want to search for products in the TutorialNinja website

  Background:
    Given the user is on the TutorialNinja website
    When the user clicks the My Account button
    And the user clicks the Login link
    And the user enters email "jeeva22@gmail.com" and password "Kiot1234"
    And the user clicks the Login button
    Then the user should see the my account text

  Scenario Outline: Search products using different keywords
    When the user searches for "<keyword>"
    Then the search result should "<result_status>"

    Examples:
      | keyword    | result_status  |
      | iMac       | contain        |
      | MacBook Pro| contain        |
      | mobile      | not contain    |