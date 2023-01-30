Feature: Login feature

  @smoke @regression
  Scenario: Login Success
    Given I open Login Page
    When I enter email "pooja.bankar@testpro.io"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in

  @smoke
  Scenario: Login with invalid email
    Given I open Login Page
    When I enter email "invalid@class.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I get an error message

  @regression
  Scenario: Login with invalid password
    Given I open Login Page
    When I enter email "pooja.bankar@testpro.io"
    And I enter password "tetudent"
    And I submit
    Then I get an error message

  @regrassion
  Scenario: Login with empty email and Password
    Given I open Login Page
    When I enter email ""
    And I enter password ""
    And I submit
    Then I get Enter Email and Password
#  Scenario Outline: Login with various input
#    Given I open Login Page
#    When I enter email <username>
#    And I enter password <password>
#    And I submit
#    Then I am logged in
#    Examples: various login input
#      | username          | password    |
#      | demo@class.com    | te$t$tudent |
#      | invalid@class.com | te$t$tudent |

