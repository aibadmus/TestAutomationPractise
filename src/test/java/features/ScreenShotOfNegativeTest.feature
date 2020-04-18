Feature: Should be able to grab a screen shot of failed test
  Scenario: I would like see screen shot of an error on page

    Given I am successfully signed in with my details
    And I go to my order history and details
    And I reorder an item without ticking the check box
    Then I can take a screen shot of the error message



