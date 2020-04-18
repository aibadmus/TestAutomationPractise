  Feature: Should be able to buy 2 items
    Scenario: Purchases 2 items with different sizes
      Given I 'Quick view’ an item
      When I Change the size of the item
      And I Add that item to my basket
      And I ‘Quick view’ a different item (leave the size at the default)
      And I Add the item to my basket
      And I View the basket to confirm that the items are of the size you selected,
      And I check that their prices are correct,
      And I Check that Total amount includes the Products with the Shipping cost
      And I Proceed through checkout to payment
      Then I should get a confirmation that my transaction is completed