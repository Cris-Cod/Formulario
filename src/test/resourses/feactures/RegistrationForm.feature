Feature: Student Registration Form

  Scenario: Validating sucessfully the form
    Given I access the form page
    When I enter a name Cristian
    And I enter a last name Arevalo
    And I enter a email karetas@gmail.com
    And I select the gender
    And I enter a mobile number "2355841896"
    And I select the birth day
    And I select a hobbies
    And I upload the picture
    And I enter a current Address
    And I select a state
    And I select a City
    And I click on the submit button
    Then Validate message to form


