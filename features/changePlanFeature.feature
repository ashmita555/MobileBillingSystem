Feature: Mobile Billing Change Plan Feature
Using this feature user can able to change plan of account

Scenario: User wants to change plan of account
Given  User is on changePlanPage Page
When  User enter his correct credentials and click on change plan button
Then  User is redirected to changePlanPage page and message gets displayed

Scenario: User wants to go to home page
Given  User is on changePlanPage Page
When  User click on home page button
Then  User is redirected to home page