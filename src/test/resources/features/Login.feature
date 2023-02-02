Feature: Login feature

  Scenario: Login Success
    Given I open login page
    When I enter email "hand923@gmail.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in

  Scenario: Login incorrect password
    Given I open login page
    When I enter email "hand923@gmail.com"
    And I enter password "incorrectpassword"
    And I submit
    Then I stay in login page

  Scenario: Login invalid email
    Given I open login page
    When I enter email "invalid@gmail.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I stay in login page

  Scenario: Login empty email empty password
    Given I open login page
    When I enter email ""
    And I enter password ""
    And I submit
    Then I stay in login page
