@smoke_thescore
Feature: Verify League, Team, or Player Data in theScore App

  Background: User need to go to Main Menu Page from Get Started Page
    Given User have the theScore app installed and opened
    When Tap on Get Started to open favorite leagues page
    Then favorite leagues page open corectly
    When Select first 2 leagues
    And  tap on Continue
    Then Check if Allow Location Popup show up
    When Tap on Maybe Later to close popup or Do nothing
    Then Choose your favorite teams page open
    When Select first 2 Teams
    And  tap on Continue
    Then Page setting customize notification open
    When Tap on Done
    Then Check if Notification permission popup show up
    When Tap on Don't Allow to close popup or Do nothing
    Then Check if TheScore Bet App popup show up
    When Tap on close button or Do nothing
    Then Main Menu page open correctly

  Scenario Outline: Verify League, Team, or Player Information
    Given Main Menu page open
    When User tap on League Page
    Then League Page open corectly
    And  Double Click on edit to avoid popup
    When User tap on the <league> league page
    Then the <league> page opens correctly
    When User tap on the <subtab> tab
    Then User is on the <subtab> tab with correct data
    When User tap on <team short name> Team
    Then <team long name> Team information open correctly
    When User navigate back
    Then User back to <league> league page

    Examples:
      | league  | subtab    | team short name | team long name |
      | NHL     | Standings | BOS Bruins      | Boston Bruins  |
      | NFL     | Standings | MIA Dolphins    | Miami Dolphins |