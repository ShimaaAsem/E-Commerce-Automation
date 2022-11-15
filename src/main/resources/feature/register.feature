@regression

Feature:Register function


  Scenario: Register with valid data
    Given User open browser and go to register page
    When user press register icon
    And user selects "female" and enters "shimaa" as first name, "asem" as last name, "shimaa@asem.com" as email, "yyy" as company, "shimaa89" as password and "shimaa89" as confirm password
    And user set his birthday as follow "24" Day "6" Month "1998" Year
    And user clicks on register button
    Then successful registration message appears

