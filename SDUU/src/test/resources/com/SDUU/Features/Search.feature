Feature: Search functionality

  Scenario: Verify no records message for invalid search
    Given User is logged in to the application
    When User selects "Direct PO" from the SRM Transaction dropdown menu
    And User performs an invalid search
    And "No records to display." message should be shown
    Then User clicks on the Hide Search button
