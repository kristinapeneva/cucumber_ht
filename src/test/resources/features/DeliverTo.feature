Feature: Deliver To Functionality

  Scenario: Verify ZipCode
    Given User is on "Home Page"
    And User clicks on deliver to button on "Home Page"
    When User enters zipcode "37219" on "Deliver To Module"
    And User clicks on apply and continue buttons on "Deliver To Module"
    And The "Home Page" is refreshed
    Then The new location contains "Nashville 37219" on "Home Page"

