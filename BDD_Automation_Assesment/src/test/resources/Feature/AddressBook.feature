Feature: Address Book Feature

  Description:
  As a logged-in user,
  I want to add a new address
  using Data Table

  Background:
    Given the user is on the TutorialNinja website
    When the user clicks the My Account button
    And the user clicks the Login link
    And the user enters email "jeeva22@gmail.com" and password "Kiot1234"
    And the user clicks the Login button
    Then the user should see the my account text

  Scenario: Add new address using data table

    When the user navigates to Address Book page
    And the user enters address details
      | firstname | John            |
      | lastname  | Doe             |
      | address1  | 123 Main Street |
      | city      | Chennai         |
      | postcode  | 600001          |
      | country   | India           |
      | region    | Tamil Nadu      |

    And the user clicks the continue button
    Then the address should be added successfully