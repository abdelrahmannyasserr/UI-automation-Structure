Feature: Spice Jet
  Scenario: As a User I want to Book a flight and make sure that's booked
    Given User is redirect to the Home Page
    Then  Choose round Trip
    When  Choose the country
    And   set the Date
    And   Set the number of passengers
    When  Choose the currency
    Then  Click on Search Flight Button
    Then Verify that the Flight isn't displayed


