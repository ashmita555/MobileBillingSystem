Feature: Mobile Billing Welcome Page Feature
Using this feature user can able to login to application

Scenario: User wants to know details of all customers
Given  User is on welcome Page
When  User clicks on Your Details link
Then  User is redirected to getAllCustomerDetailsPage page and get details of all customers

Scenario: User wants to open new postpaid mobile account
Given  User is on welcome Page
When  User clicks on Open Post Paid Mobile Account link
Then  User is redirected to openPostpaidMobileAccount page

Scenario: User wants to generate monthly mobile bill
Given  User is on welcome Page
When  User clicks on Generate Monthly Mobile Bill link
Then  User is redirected to generateBill page

Scenario: User wants to know mobile bill details
Given  User is on welcome Page
When  User clicks on Mobile Bill Details link
Then  User is redirected to getMobileBillDetails page

Scenario: User wants to change plan for a account
Given  User is on welcome Page
When  User clicks on Change Your Account Plan link
Then  User is redirected to changePlan page

Scenario: User wants to know details of plans
Given  User is on welcome Page
When  User clicks on Plan Details link
Then  User is redirected to getPlanAllDetails page

Scenario: User wants to know details of all postpaid account
Given  User is on welcome Page
When  User clicks on Get Customer All Post Paid Account Details link
Then  User is redirected to getCustomerAllPostpaidAccountsDetails page

Scenario: User wants to delete customer account
Given  User is on welcome Page
When  User clicks on Delete Customer link
Then  User is redirected to deleteCustomer page
