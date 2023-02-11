Feature: Login feature

  Scenario: Login Success
    Given I open browser
    When I enter email "email"
    And I enter password "password"
    And I submit
    Then I am logged in
