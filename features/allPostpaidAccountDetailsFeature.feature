Feature: Mobile Billing All Postpaid Account Details Feature
Using this feature user can able to get details of all postpaid accounts of a customer

Scenario: User wants to know details of all postpaid accounts of a customer 
Given  User is on getCustomerAllPostpaidAccountsDetailsPage Page
When  User enter his correct credentials and click on postpaid account details button
Then  User is redirected to getCustomerAllPostpaidAccountsDetailsPage page and details gets displayed

Scenario: User wants to go to home page
Given  User is on getCustomerAllPostpaidAccountsDetailsPage Page
When  User click on home page button
Then  User is redirected to home page