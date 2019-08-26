@so
Feature: Wikipedia search functionality

  Scenario Outline: Wikipedia Search Functionality Title Verification
    Given User is on Wikipedia homepage
    When User types "<searchKey>" in the wiki search box
    And User clicks wiki search button
    Then User sees "<title>" is in the wiki title

    Examples: Test data for search functionality

      | searchKey    | title        |
      | Esen Niiazov | Esen Niiazov |
      | Ricky Martin | Ricky Martin |
      | Lady Gaga    | Lady Gaga    |
      | Lionel Messi | Lionel Messi |

    #option command L for aligning pipes automatically --> this is for mac
   # ctrl alt L for windows