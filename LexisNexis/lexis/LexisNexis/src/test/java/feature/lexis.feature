Feature: Job Search on LexisNexis Website
  As a potential job applicant
  I want to search for 'automation tester' positions
  So that I can find relevant job opportunities at LexisNexis

  Scenario: Search for Automation Tester Jobs
    Given I open the LexisNexis homepage
    When the user navigates to the "About Us" page and then to Careers
    And the user clicks on Search all jobs
#    And the user searches for "automation tester" in the search box
#    Then the user should see at least one search results
