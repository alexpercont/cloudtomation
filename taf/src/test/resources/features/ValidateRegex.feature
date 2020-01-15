Feature: Validate text against regular expression.

  As a visitor I want to type a text in a field and validate against a regular expression.

  Scenario: Validate regular expression
    Given I open the Cloudtomation application
    Then I validate text 'aaaa' against regex 'a'
    Then I see a message saying Success