Feature: Play Songs

  @smoke @regression @playsong
  Scenario: Play A Song From the Songs Page
    Given I am logged in and on the home page
    When I click on All Songs
    And I double click a song
    Then the song should start playing
    And the sound visualizer should be displayed

