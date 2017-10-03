Feature: Homework 5

  Scenario: Test Different Elements Page
    Given I open "https://jdi-framework.github.io/tests/"
    And I login as epam/1234
    And I check that dispalyed name in the right-top side of screen is "PITER CHAILOVSKII"
    And I check that Home page contains 4 pictures, 4 texts under them, 2 text above
    And I check that header Service menu contains options: SUPPORT, DATES, COMPLEX TABLE, SIMPLE TABLE, TABLE WITH PAGES, DIFFERENT ELEMENTS
    And I check that left section Service subcategory contains options: Support, Dates, Complex Table, Simple Table, Table with pages, Different elements
    And I open through the header menu Service page: "Different Elements"
    When I check Different Elements page contains 4 - checkboxes, 4 radios, dropdown, 2 - buttons, left section, right section.
    And I select Water checkbox and assert it
    And I select Wind checkbox and assert it
    And I select Selen radio
    And I select Yellow dropdown
    And I unselect and assert checkbox Water
    And I unselect and assert checkbox Wind
    Then Logs contains "Water: condition changed to true"
    And Logs contains "Wind: condition changed to true"
    And Logs contains "metal: value changed to Selen"
    And Logs contains "Colors: value changed to Yellow"
    And Logs contains "Water: condition changed to false"
    And Logs contains "Wind: condition changed to false"


