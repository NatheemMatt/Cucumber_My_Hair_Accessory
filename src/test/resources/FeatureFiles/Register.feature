Feature: Validate Adactin Hotel Register Functionality

  @dataTable
  Scenario: Register new user with valid details
    Given User launches the browser
    And User navigates to Adactin Hotel register page
    When User enters registration details
      | natheem123 | Test@123 | Test@123 | Natheem Irfan | natheem@test.com |
    And User enters captcha manually
    And User accepts terms and conditions
    And User clicks register button
    Then User should see registration success message
