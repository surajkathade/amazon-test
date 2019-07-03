Feature: Amazon Test

Scenario: First Test
Given Open Amazon website
And Login to the portal
When Search for product "Fossil Analog Unisex Watch - FS4656"
And sort result by price-ascending order
And add searched product to shopping cart
Then verify product and quantity is displaying in the cart
And logoff
