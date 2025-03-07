Feature: Upload Resume on Naukri

  Scenario: User uploads resume successfully
    Given User is on Naukri login page
    When User logs in with valid credentials
    And User navigates to the resume upload section
    And User uploads the resume file
    Then Resume should be uploaded successfully
