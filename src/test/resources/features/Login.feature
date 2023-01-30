Feature: Login feature

  @Smoke @Regression
  Scenario: Login Success
    Given I open Login Page
    When I enter email "test123@test.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in

  @Regression
  Scenario: Login with incorrect password
    Given I open Login Page
    When I enter email "test123@test.com"
    And I enter password "teststudent"
    And I submit
    Then I get an error message

  @Regression
  Scenario: Login with not existing email
    Given I open Login Page
    When I enter email "invalid@test.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I get an error message

  @Regression
  Scenario: Login with empty Email and Password
    Given I open Login Page
    When I enter email ""
    And I enter password ""
    And I submit
    Then I get a message enter email and password
