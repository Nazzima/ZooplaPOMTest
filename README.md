# ZooplaPOMTest
Test Automation of Zoopla website pages for coding challenge assignment using Java,Selenium,TestNg,Jenkins & Github.
See below for the instructions of Coding Challenge:
Steps:
1) go to this url -https://www.zoopla.co.uk/
2) Input location London and click submit
3) You will get a list of properties on that page. 
4) Print all the price values in sorted order (descending order) on the console
5) I need to select the 5th property on that list (its changing every minute, so it’s dynamic) 
6) On the next page, there is a logo, name and telephone no of the agent. I need to click on the name link to get into the agent’s page.
7) Once on that page, I need to check that the the properties listed there belong to the same mentioned agent on the page.

Solution Expectations:
- JAVA is mandatory
1. Code should be designed within Page Object Model
2.  Define all the proper variables and methods names
3. Code should work without any error
4. Use TestNG library to write the test cases
5. Use valid required assertions
6. Share your GIT Repo or ZIP file.

My Solution:
                     
   In Eclipse, I created 4 classes for 4 pages of Zoopla site with Page Factory design pattern for the web elements.Then tests these pages using those web elements to do the expected actions.To do this ,I made 5 Test classes: 1 for each page & one extra for home page using different 
sets of search input test data from Excel sheet(used Data Provider:TestNG). Used testng.xml file to run the test cases of all web pages.The test reports are created after the test run.
Pushed the code to Github & used Jenkins to run the tests again.Jenkins is not required for the coding challenge,but I challenged myself with this extra step.
This test automation is good example for smoke testing!


Find page definitions under src/main/java/webPages:HomePage,SearchListPage,DesiredListPage,ListAgentPage & HomeSearchPage

Find test definitions under src/test/java/seleniumTest:HomePageTest,SearchListPageTest,DesiredListPageTestn& HomeSearchPageTest

Check tesng.xml file under src/main/resources

Check test reports under test-output or Click the links below to see Reports 

htmlReport:  https://user-images.githubusercontent.com/60820662/93220047-0149d080-f73a-11ea-9256-c7458fa409f0.png

Extent Report : https://user-images.githubusercontent.com/60820662/93215027-e5433080-f733-11ea-9f93-7330e9602474.png

Test Report from Jenkins :https://user-images.githubusercontent.com/60820662/93215194-115eb180-f734-11ea-8f96-9c131b846bb8.png

TestNG Suite Results: https://user-images.githubusercontent.com/60820662/93215039-e7a58a80-f733-11ea-982f-18bd5e661e71.png


