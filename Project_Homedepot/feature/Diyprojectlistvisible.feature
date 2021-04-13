Feature: Options in DIY Projects & Ideas List should appear
Scenario:
Given user is on Home Depot web page: 
|https://www.homedepot.com/|
	And the browser window is maximized
When user points mouse over "DIY Projects & Ideas" link
Then a dropdown should appear showing four columns: 
|Diyprojectslist|
|Home Decor Ideas|
|Home Improvement|
|Outdoor Living Ideas|
|Home Entertaining|

