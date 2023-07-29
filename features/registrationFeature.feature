Feature: Mobile Billing Registration Feature
Using this feature user can able to open a new account

Scenario: User wants to open new account  
Given  User is on registration Page
When  User enter his correct personal details and click on submit button
Then  User is redirected to registration page and message gets displayed

Scenario: User wants to open new account with empty fields  
Given  User is on registration Page
When  User enter incorrect personal details with empty fieldsand click on submit button
Then  User gets error message
