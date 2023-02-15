Feature: Play a Song

  @smoke
  Scenario: Play a song
    Given I open Login Page
    And I enter email "tatsianahuryeva@yahoo.com"
    And I enter password "te$t$tudent"
    And I submit
    And I open AllSong Page
    And I selected first song
    When I double click the song
    Then The song should playing