Feature: Deliver To Functionality

  Scenario: Verify ZipCode
    Given User is on "Deliver To Module"
    When User enters zipcode "37219"
    And User clicks on "Apply Button"
    And User clicks on "Continue Button"
    And The page is refreshed
    Then The new location contains "Nashville 37219"