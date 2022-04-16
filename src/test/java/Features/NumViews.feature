Feature: Validate Response NumViews Values Greater Than 4000

  Background: Go To API Endpoint
    Given User Go To Patterns service api endpoint


  Scenario: Get ColourLovers Request and Assert for <NumViews>
    When  User Set Request Headers
    Then  Verify numViews Values Greater Than 4000

