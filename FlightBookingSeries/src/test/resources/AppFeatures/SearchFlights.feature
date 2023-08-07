Feature: Search flights 
@SmokeTest
Scenario Outline: Test if the flights are available from any two destinations
Given User is in the search flights page
When user performs search with information for "<departure>","<destination>","<start_date>" and "<end_date>"
And user clicks on Search flights
Then user lands in results screen to check availability of flights

Examples:
|departure|destination|start_date  |end_date|
|Stansted   |Mumbai        |8 August '23 |8 September '23|
|Paris   |Mumbai           |9 August '23 |6 September '23|




@SmokeTest
Scenario Outline: User chooses different options and verifies flight details
Given User is in the search flights page
When user selects "<way>" and "<class>"
When user performs search with data for "<From>","<To>" and "<start_date>"
And user clicks on Search flights
Then user lands in results screen to check availability of flights

Examples:
|way       |class        |From    |To    |start_date|
|One way|Premium economy |London  |Mumbai|28 August '23|

