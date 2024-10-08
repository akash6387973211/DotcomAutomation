Feature: check Listing Dse

  Background:
    Given Set chrome WebDriver

     Scenario Outline: Check Seo Section
      Given Launch url at "<url>"
      When user clicks on seo sections it should not return 404
      Examples:
      |url|
      |https://www.squareyards.com/sale/property-for-sale-in-ahmedabad|
      |https://www.squareyards.com/sale/property-for-sale-in-bangalore|