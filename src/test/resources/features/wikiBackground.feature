@wikiBackground
Feature: Wikipedia search functionality

  Background: User searched for given text
    Given User is on Wikipedia homepage
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button

  Scenario: Wikipedia Search Functionality Title Verification
    Then User sees "Steve Jobs" is in the wiki title

  Scenario: Wikipedia Search Functionality Main Header Verification
    Then User sees "Steve Jobs" is in the main header

  Scenario: Wikipedia Search Functionality Image Header Verification
    Then User sees "Steve Jobs" is in the image header