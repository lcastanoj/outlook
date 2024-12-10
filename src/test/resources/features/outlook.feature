Feature: Outlook Login

  Scenario: User can successfully log in to Outlook
    Given the user is on the Outlook login page
    And the user gets the two step verification
    When they enter their email "laucasj13@hotmail.es" and password "Sali0313."
    Then they should see their inbox
