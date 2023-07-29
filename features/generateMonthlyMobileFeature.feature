Feature: Mobile Billing Generate Monthly Mobile Bill Feature
Using this feature user can able to generate monthly mobile bill

Scenario: User wants to generate monthly mobile bill  
Given  User is on generateMonthlyMobileBillPage Page
When  User enter his correct credentials and click on submit button
Then  User is redirected to generateMonthlyMobileBillPage page and message gets displayed

Scenario: User wants to go to home page
Given  User is on generateMonthlyMobileBillPage Page
When  User click on home page button
Then  User is redirected to home page