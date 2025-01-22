Feature: eBay Automation Test

  Scenario Outline: Add a book to the cart
#    Given I open the browser and navigate to ebay
    When I search for "<category>"
    And I click on the first book in the search results
    And I add the item to the cart
    Then the cart should display the number of items as "1"
    
    Examples:
    |category|
    |book|