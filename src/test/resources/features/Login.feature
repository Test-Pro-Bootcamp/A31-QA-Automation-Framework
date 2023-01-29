Feature: Login feature
  @regression @smoke
  Scenario: Login Success
    Given I open Login Page
    When I enter email "jrpasia@gmail.com"
    And I enter password "Bukikoy2013"
    And I click submit
    Then I am logged in
