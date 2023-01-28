Feature: Login feature

  Scenario: Login Success
    Given I open browser
    And I open Login Page
    When I enter email "jrpasia@gmail.com"
    And I enter password "Bukikoy2013"
    And I submit
    Then I am logged in
