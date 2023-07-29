Feature: Mobile Billing Login Feature
Using this feature user can login to the account

Scenario: User wants to login to the account by entering valid set of words
Given User is on login page
When User enter valid customer id to login into the account and click on login button
Then User goes to the welcome page

Scenario: User wants to login to the account by entering invalid set of words
Given User is on login page
When User enter invalid customer id to login into the account and click on login button
Then User gets the error message

Scenario: User wants to open the account
Given User is on login page
When User clicks on the New User link
Then User goes to the open account page