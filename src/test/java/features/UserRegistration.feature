Feature: User Registration
      I want to check that the user can register in Cervello

  Scenario Outline: User Registration
    Given The user in the home page
    When He clicks on Register link
    And He entered "<firstName>" , "<laseName>" , "<email>" , "<password>"
    Then The registration page displayed successfully
    Examples:
      | firstName | laseName | email | password |
      | ahmed | mohamed | ahmed@user21434.com | 12345678 |
      | Moataz | ahmed | test@newuser12233.com | 87654321 |