Feature: Mobile Billing Open Postpaid Mobile Account Feature
Using this feature user can able to open a new postpaid account

Scenario: User wants to open new postpaid mobile account  
Given  User is on openPostpaidMobileAccountPage Page
When  User chooses his plan and click on submit button
Then  User is redirected to openPostpaidMobileAccountPage page and message gets displayed

Scenario: User wants to go to home page
Given  User is on openPostpaidMobileAccountPage Page
When  User click on home page button
Then  User is redirected to home page