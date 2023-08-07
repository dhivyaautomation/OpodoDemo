Feature: User selects class and trip details

@SmokeTest
Scenario Outline: User chooses the  cheapest fare
Given User is in the search flights page
When user selects "<way>" and "<class>"
When user performs search with data for "<From>","<To>" and "<start_date>"
And user clicks on Search flights
Then user lands in results screen to check availability of flights
And user selects best cheapest flight option

Examples:
|way    |class    |From    |To    |start_date|
|One way|Business |London  |Mumbai|22 August '23|