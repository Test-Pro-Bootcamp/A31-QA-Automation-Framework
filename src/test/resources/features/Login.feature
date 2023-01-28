Feature: Login feature

  Scenario: Login Success
    Given I open Login Page
    When I enter email "shalinibaronia@gmail.com"
    And I enter password "te$tStudent"
    And I submit
    Then I am logged in