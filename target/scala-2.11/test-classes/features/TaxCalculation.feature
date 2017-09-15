# new feature
# Tags: optional
    
Feature: Tax Calculator
    
Scenario: Complete tax calculation
    Given I navigate to the tax calculator page
    When I enter an amount and navigate with no to all option
    And I select get results
    Then I land on the pension info page