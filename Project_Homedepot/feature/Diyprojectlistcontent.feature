Feature: Verify options in "DIY Projects & Ideas" project ideas list.

Scenario:
Given user is on Home Depot web page: 
|https://www.homedepot.com/|
	And the browser window is maximized
When user points mouse over "DIY Projects & Ideas" link
Then "Home Decor Ideas" list should have:
|Bathroom Ideas & Projects|
|Living Room Ideas & Projects|
|Paint Ideas & Projects|
|Bedroom Ideas & Projects|
|Kitchen Ideas & Projects|
|Dining Room Ideas & Projects|
|Flooring Ideas & Projects|
|Hallway & Wall Ideas & Projects|
|Ceiling Fan Ideas & Projects|
|Small Spaces|
|Home Accent Ideas & Projects|
Then "Home Improvement" list should have:
|Electrical Wiring|
|Windows & Window Treatment Ideas|
|Door Ideas & Projects|
|Appliance Guides|
|DIY Plumbing|
|Home Heating & Cooling Guides|
|Hardware and Tool Guides|
|Building Material Guides|
|Home Safety & Security|
Then "Outdoor Living Ideas" list should have:
|Lawn & Landscaping Ideas & Projects|
|Garden Ideas & Projects|
|DIY Pest Control|
|Outdoor Lighting Ideas|
|Outdoor Recreation|
|Outdoor Décor Ideas & Projects|
|Grill Guides|
Then "Home Entertaining" list should have:
|Halloween Ideas & Projects|
|Christmas Ideas & Projects|
|Thanksgiving Ideas & Projects|
|Parties & Events|
|Cooking Guides|
||
||
|Trending|
|Activites for Kids|
|Gift Ideas|
|All DIY Projects|
|Free DIY Workshops|
