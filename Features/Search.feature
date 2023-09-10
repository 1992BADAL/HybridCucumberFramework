Feature: Search functionality

Scenario: User search for a valid product
Given User opens application
When User enters valid product "HP" into search box field
And User clicks on search button
Then User should get valid product displayed in search result

Scenario: User search for an invalid product
Given User opens application
When User enters invalid product "Honda" into search box field
And User clicks on search button
Then User should get a message about no product matching

Scenario: User searches without any product
Given User opens application
When User dont enters any product name into search box field
And User clicks on search button
Then User should get a message about no product matching
