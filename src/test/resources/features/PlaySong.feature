Feature: Play Song feature

Scenario: Play a song
  Given I open all songs page
  When I select the first song
  And I double click the song
  Then I played a song