Feature: App landing page testing

  @Sanity
  Scenario: Verify bottom navigation bar in app landing page
    Given User launches the app
    When User is in app landing page
    Then Verify the navigation bar in app landing page

  @Sanity
  Scenario: Verify search movies feature
    Given User launches the app
    When User is in app landing page
    Then Verify user is able to see the search option
    When User clicks on search option and start search a movie valid name
    Then Verify movies is appeared in search list
