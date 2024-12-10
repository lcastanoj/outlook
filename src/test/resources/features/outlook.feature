Feature: Outlook Login

  Scenario: User can successfully log in to Outlook
    Given the user is on the Outlook login page
    When they enter their email "laucasj13@hotmail.es" and password "SaLi0313."
    And the user gets the two step verification
    Then they should see their inbox
