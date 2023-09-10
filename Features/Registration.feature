Feature: Registration functionality

  Scenario: User creates an account only with mandatory fields
    Given User navigates to Registration Account page
    When User enters the details into below fields
      | firstName | Badal                      |
      | lastName  | Mondal                   	 |
      | telephone | 1234567890                 |
      | password  | 1234                       |
    And User selects privacy policy
    And User clicks on continue button
    Then User account should created successfully

  Scenario: User creates an account with all fields
    Given User navigates to Registration Account page
    When User enters the details into below fields
      | firstName | Badal                      |
      | lastName  | Mondal                     |
      | telephone | 1234567890                 |
      | password  | 1234                       |
    And User selects Yes for Newsletter
    And User selects privacy policy
    And User clicks on continue button
    Then User account should created successfully

  Scenario: User creates a duplicate account
    Given User navigates to Registration Account page
    When User enters the details into below fields with the duplicate email
      | firstName | Badal                      |
      | lastName  | Mondal                     |
      | email     | mondalbadal79@gmail.com 	 |
      | telephone | 1234567890                 |
      | password  | 1234                       |
    And User selects Yes for Newsletter
    And User selects privacy policy
    And User clicks on continue button
    Then User should get a proper warning about duplicate emali

  Scenario: User create an account without filling any details
    Given User navigates to Registration Account page
    When User dont enter any details into fields
    And User clicks on continue button
    Then User should get a proper warning message for mandatory field
