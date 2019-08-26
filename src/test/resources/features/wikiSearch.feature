@wiki
Feature: Wikipedia search functionality

  Scenario: Wikipedia Search Functionality Title Verification
    Given User is on Wikipedia homepage
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the wiki title

  Scenario: Wikipedia Search Functionality Main Header Verification
    Given User is on Wikipedia homepage
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the main header

  Scenario: Wikipedia Search Functionality Image Header Verification
    Given User is on Wikipedia homepage
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the image header