Feature: Validate Response NumViews Values Greater Than 4000

  Scenario: Get ColourLovers Request and Assert for <NumViews>
    Given User Set Patterns service api endpoint
    When  User Set Request Headers
    Then  Verify numViews Values Greater Than 4000

