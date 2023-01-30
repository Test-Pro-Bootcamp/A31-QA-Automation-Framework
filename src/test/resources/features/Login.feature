Feature: Login feature

  Scenario: Login Success
    Given I open Login Page
    When I enter email "shalinibaronia@gmail.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in

  Scenario: Login with incorrect password
    Given I open Login Page
    When I enter my email "shalinibaronia@gmail.com"
    And I enter incorrect password "te$tstudent"
    And I click submit
    Then I am not logged in

  Scenario: Play a song
    Given I open Homepage
    When I context click on song
    And I click play button
    And Song is playing
