Feature: Play a Song

  @smoke
  Scenario: Play a song
    Given I open AllSong Page
    When I selected first song
    And I double click the song
    Then The song should playing