Feature: Clicking on a link in DIY Projects & Ideas option should load the page relevant to that link
Scenario:
Given user is on Home Depot web page: 
|https://www.homedepot.com/|
And the browser window is maximized
Given a list of page attributes in a table
|link||pageheading|
|Bathroom Ideas & Projects||Bathroom Ideas & Projects|
|Living Room Ideas & Projects||Living Room Ideas & Projects|
|Paint Ideas & Projects||Paint Ideas & Projects|
|Bedroom Ideas & Projects||Bedroom Ideas & Projects|
|Kitchen Ideas & Projects||Kitchen Ideas & Projects|
|Dining Room Ideas & Projects||Dining Room Ideas & Projects|
|Flooring Ideas & Projects||Flooring Ideas & Projects|
|Hallway & Wall Ideas & Projects||Hallway & Wall Ideas & Projects|
|Ceiling Fan Ideas & Projects||Lighting & Ceiling Fan Ideas & Projects|
|Small Spaces||Small Spaces|
|Home Accent Ideas & Projects||Home Accent Ideas & Projects|
|Electrical Wiring||Electrical Wiring|
|Windows & Window Treatment Ideas||Windows & Window Treatment Ideas|
|Door Ideas & Projects||Door Ideas & Projects|
|Appliance Guides||Appliance Guides|
|DIY Plumbing||DIY Plumbing|
|Home Heating & Cooling Guides||Home Heating & Cooling Guides|
|Hardware and Tool Guides||Hardware & Tool Guides|
|Building Material Guides||Building Material Guides|
|Home Safety & Security||Home Safety & Security|
|Lawn & Landscaping Ideas & Projects||Lawn & Landscaping Ideas & Projects|
|Garden Ideas & Projects||Garden Ideas & Projects|
|DIY Pest Control||DIY Pest Control|
|Outdoor Lighting Ideas||Outdoor Lighting Ideas|
|Outdoor Recreation||Outdoor Recreation|
|Outdoor D�cor Ideas & Projects||Outdoor Decor Ideas & Projects|
|Grill Guides||Grill Guides|
|Halloween Ideas & Projects||Halloween Ideas & Projects|
|Christmas Ideas & Projects||Christmas Ideas & Projects|
|Thanksgiving Ideas & Projects||Thanksgiving Ideas & Projects|
|Parties & Events||Parties & Events|
|Cooking Guides||Cooking Guides|
|[blank]||[blank]|
|[blank]||[blank]|
|Trending||Trending|
|Activites for Kids||Activities for Kids|
|Gift Ideas||Gift Ideas|
|All DIY Projects||DIY Projects and Ideas|
|Free DIY Workshops||Workshops|
When user points mouse over "DIY Projects & Ideas" link
When user points mouse over option "Activites for Kids" and clicks
Then a page with page heading relevant to the option "Activites for Kids" should open
