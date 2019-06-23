Feature: Should be able to review previous orders
  Scenario: I would like to review my previous orders

    Given I am successfully signed in with my details
    And I go to my order history and details
    Then I can see my previous orders
    Then I can confirm the date of purchase of previous order
    And I add a comment
    Then I should be able to see the comment added
