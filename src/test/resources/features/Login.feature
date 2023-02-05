Feature: Login feature

  @smoke
  Scenario: Login Success
    Given I open Login Page
    When I enter email "amandaag39@gmail.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in