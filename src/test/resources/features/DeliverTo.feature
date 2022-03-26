Feature: Deliver To Functionality

  Scenario: Verify ZipCode
    Given User is on "Home Page"
    And User clicks on deliver to button on "Home Page"
    When User enters zipcode "37219" on "Deliver To Module"
    And User clicks on apply and continue buttons on "Deliver To Module"
    And The "Home Page" is refreshed
    Then The new location contains "Nashville 37219" on "Home Page"

  Scenario: Verify Poland is in the list of shipping countries
    Given User is on "Home Page"
    And User clicks on deliver to button on "Home Page"
    Then User can choose "Poland" from the dropdown menu of locations on "Deliver To Module"

  Scenario: Check if the shipping country is true
    Given User is on "Home Page"
    And User clicks on deliver to button on "Home Page"
    When User chooses shipping country "Bulgaria" and clicks on done button on "Deliver To Module"
    And The "Home Page" is refreshed
    And User chooses a category on "Home Page"
    And User chooses item on "Category Page"
    Then The shipping country is "Bulgaria" on "Item Page"

