Feature: Login feature

  @smoke @regression
  Scenario: Login Success
    Given I open Login Page
    When I enter email "demo@class.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in

  @smoke @regression
  Scenario: Login with invalid
    Given I open Login Page
    When I enter email "invalid@class.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in

#  Scenario Outline: Login with various input
#    Given I open Login Page
#    When I enter email <username>
#    And I enter password <password>
#    And I submit
#    Then I am logged in
#    Examples: various login input
#    |username|password|
#    |demo@class.com|te$t$tudent|
#    |invalid@class.com|te$t$tudent|