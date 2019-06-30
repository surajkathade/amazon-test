Feature: Amazon Test

Scenario: First Test
Given Open "https://www.amazon.in/" website
And Login to the portal
#When Search for product "Fossil Analog Unisex Watch - FS4656"
#And sort result by price-ascending order
#And add product "Fossil Analog Unisex Watch - FS4656" to shopping cart
Then verify product and quantity is displaying in the cart
And logoff
