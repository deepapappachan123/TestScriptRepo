Feature: Add four different products to the wish list and add lowest price item to the cart

  Scenario: Add four different products to the wish list and add lowest price item to the cart
    Given I add four different product to my wishlist
    When I view my wishlist table
    Then I find total four selected item in my Wishlist
    When I search for lowest price product
    And I am able to add my lowest price item to my cart
    Then I am able to verify the item in my cart