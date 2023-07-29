Feature: Mobile Billing Delete Customer Feature
Using this feature user can able to delete customer

Scenario: User wants to delete customer
Given  User is on deleteCustomerPage Page
When  User enter his correct credentials and click on delete customer button
Then  User is redirected to deleteCustomerPage page and message gets displayed

Scenario: User wants to go to home page
Given  User is on deleteCustomerPage Page
When  User click on home page button
Then  User is redirected to home page