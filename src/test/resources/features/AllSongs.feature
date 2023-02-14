Feature: Play a Song

  @smoke
  Scenario: Play a song
    Given I open Login Page
    And I enter email "tatsianahuryeva@yahoo.com"
    And I enter password "te$t$tudent"
    And User navigate to All Song Page
    When User selected first song
    And  User double click the song
    Then The song should playing