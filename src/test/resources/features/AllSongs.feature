Feature: Play a Song

  @smoke
  Scenario: Play a song
    Given User navigate to All Song Page
    When User selected first song
    And  User double click the song
    Then The song should playing