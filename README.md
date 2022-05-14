Introduction:
The “Automation framework is Cucumber using Java with maven build tool” framework is developed to cater front end automation support for browser based testing. The main libraries used are selenium webdriver. Tests are written in BDD format using cucumber ghekin language.


**Prerequisites: ** Test execution is carried with

Java latest version above 1.7
MAVEN – latest version
No Drivers are required as Webdriver Manager is used to manager drivers 



**How To Run Tests:

Assumptions:
Execution is pretty simple:
Navigate to project folder I e till pom.xml
Run command “mvn clean install “
UI test executions starts
To check for report, go to “target\cucumber-html-report\index.html”
Note : Update browser property in config.properties to change browser type



**Run with specific tags

Command to run : mvn clean verify -Dcucumber.options="--tags "
Following are the tags can be used to run individually, please have look at feature files for more details about the scenario specific to tag @sceanrio1,@sceanrio2



**Test Cases Overview:

Following is the location of UI test cases in the project
src\test\java\features\Automated.feature



**Manual Test cases are found under: 

src\test\java\features\ Manual_Test_Sceanrios.feature
# Gymondo_Task
