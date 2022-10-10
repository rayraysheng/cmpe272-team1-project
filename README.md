# cmpe272-team1-project

## Project Planning - Internal Use ##

### Overview ###

Project Codename: ProteinPricer

Abstract:

Develop a web application that will help dieters, athletes, bodybuilders, etc. decide what grocery items to buy to get the most bang for their buck while satisfying their daily macronutrients needs. 

There are a lot of apps out there that help track meals, calories, and macros, but this one cares more about the economic aspect of it. For example, an athlete needs 180g of protein per day, is protein powder or chicken breast a better choice if he wants to save money? 

Users would be able to easily calculate and compare the price per gram value for protein, carbs, and/or fat for any grocery or food items they enter into the web app. We will also keep a database of common food items that these users might prefer and they can select them from the database without having to manually enter them.

Persona: Britney the bodybuilder on a budget

Business Value: This is an application for individual users, it helps consumers make decisions about their food choices from an economic standpoint. This more necessary than ever now with inflation on the rise. If time allows, we can also implement a feature that enables businesses to list their deals on food/grocery items to attract users. For example, Safeway is having a sale on chicken breast, which used to cost $0.03/g of protein now costs $0.02/g.

### App Features and Functions ###

#### Example ####

![App Functionality Example](images/function_example.jpg)

#### Minimum Viable Product ####

This is the most essential functionality of the app. Once we get this feature to work, the rest of the features will be much easier to implement.

Have a single page where the user can search for a specific food item from the database and enter the price and number of servings, the app will automatically show the cost per gram of protein (or maybe grams of protein per dollar instead?).

In addition, we can also easily add a field to display the dollar cost per 2000 calories for users that don't care about specific macros but instead just need to find an affordable way to sustain a lot of people.

#### Other Core Features to Include ####

We should implement these features before the end of the project to present it as a complete app.

1. [Authenticate user logins](https://developer.android.com/training/id-auth)
	- the purpose is to accommodates features that save and access user-provided data
1. Allow the user to save and remove search results to the app screen, along with their price per gram value so the user can easily compare them.
	- requires the user login feature (unless we want save the list locally on the user's machine, which is not ideal)

#### Non-core Features ####

These are ideas for non-essential additional features that would be nice to have for a better user experience or extension of functionalities beyond the initial expectations. 
We are likely to not have time to implement these features. If we have time to add thoese, great, if not, no big deal.

1. Allow the user to save a number for grams of daily protein intake, then each searched food item will also show the theoretical daily cost of protein.
	- requires the user login feature (unless we want save the list locally on the user's machine, which is not ideal
1. Enable merchant accounts to display their deals on the app.
1. Integrate the [Protein Digestibility Corrected Amino Acid Score](https://en.wikipedia.org/wiki/Protein_Digestibility_Corrected_Amino_Acid_Score) concept into the calculations.
	- not all proteins are created equal, this would adjust the price values displayed to account for protein quality
	- this would be especially helpful for users with dietary restrictions that need to avoid eggs, dairy product, soy, etc. 
1. Add/expand the options menu to allow the user to customize which information they want to display in the app
	for example:
	- grams per dollar or dollars per gram
	- show or hide dollars per 2000 Calories

### Tasks ###

1. Finalize tools, technologies, resources
	1. Application:
		-Build app with **Android Studio** in **Java**
	1. Database: 
		- For each user, we will need to store a list of the users' saved searches. If we end up implementing the daily protein intake feature and/or the options menu feature, we will also need to save that data.
		- As for the food database itself, we can manually download and store a selection of food data in our own database, or we can use an API key to directly access the FDA-provided data. We should have the person in charge of this portion of the project make the decision.
		1. Type: Most likely SQL? Any other suggestions?
		1. Provider: 
			- Need to make sure we can connect to it in our Android app
			AWS? GCP? Other? Any preferences among our team members?
		1. Data source: [FDA FoodData Central](https://fdc.nal.usda.gov/api-guide.html)
	1. Are there any other architectural components that we need to take into consideration?

1. Division of Responsibilities
	1. Application
		1. Software design & architecture
			- will need to coordinate with the database person to figure out how to handle the search function, i.e. how to take the specific input from the user and get the right information from the database
		1. UI design & implementation
	1. Database
		1. Research and choose the provider
		1. User options data: build the database and provide APIs for the app to access database
		1. FDA Data
			- If we are maintaining our own food databse, then build the database and provide APIs for the app to access database
			- If we are directly using the FDA's API, then develop the specific code for the app to access the exact data that we need
	1. Is there anything else that comes to mind that we need to do right now?