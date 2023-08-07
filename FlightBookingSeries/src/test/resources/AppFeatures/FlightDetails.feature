Feature: flight details check

@SmokeTest
Scenario Outline: Flight details - check if window seat or not
Given User is in the search flights page
When user performs search with information for "<departure>","<destination>","<start_date>" and "<end_date>"
And user clicks on Search flights
Then user lands in results screen to check availability of flights
And user selects best cheapest flight option
#When user navigates to Summary page
Then user selects and verifies "<seat>" type


Examples:
|departure   |destination   |start_date    |end_date        |seat|
|Stansted    |Mumbai        |29 August '23 |11 September '23|12A|



@SmokeTest
Scenario Outline: Verify user is in Summary page
Given User is in the search flights page
When user performs search with information for "<departure>","<destination>","<start_date>" and "<end_date>"
And user clicks on Search flights
Then user lands in results screen to check availability of flights
And user selects best cheapest flight option
Then user navigates to Summary page

Examples:
|departure   |destination   |start_date    |end_date        |
|Stansted    |Mumbai        |29 August '23 |11 September '23|
