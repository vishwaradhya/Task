@UI
Feature: This feature is to verify My Plan functionality 
   
Background:
Given user launch the gymondo url
And user logs into gymondo app with valid credentials



@Scenario1 
Scenario: Verify the welcome message and today's workouts feature for each time user logs in 
    Given user verifies successful login page for Gymondo home page
    When user verifies the default page as My Plan after successful login
    Then user verifies the welcome message as per login time
    And user verifies today's workout tasks in the welcome page 
		And user logs out of Gymondo app 




@Scenario2 
Scenario: Verify the Time line feature for upcoming and completed workouts   
   Given user verifies successful login page for Gymondo home page
    And user verifies the default page as My Plan after successful login
    When user opens timeline 
    Then user verifies Upcoming workouts are listed as per the plan settings
    And user clicks on Completed tab
    And user verifies the completed workouts are listed
		And user logs out of Gymondo app 




@Scenario3 
Scenario: Verify the Plan settings pause and Resume program functionality  
    Given user verifies successful login page for Gymondo home page
    And user verifies the default page as My Plan after successful login
    And user opens plan settings
    And user verifies that plan settings is launched successfully
    When user clicks PAUSE button from plan settings page
    Then user verifies "Pause Program?" message is shown to user 
    And user confirms the pause operation by clicking on PAUSE PROGRAM button
    And user verifies the status "Paused" under overiew section in My Plan
    And user opens plan settings
    And user verifies that plan settings is launched successfully
    And user clicks on RESUME PROGRAM button 
    And user verifies that status "Paused" is removed from overiew section in My Plan
    And user logs out of Gymondo app 



@Scenario4 
Scenario: Verify End Program functionality in Plan setting 
		Given user verifies successful login page for Gymondo home page
    And user verifies the default page as My Plan after successful login
    And user already created a workout plan
    And user opens plan settings
    And user verifies that plan settings is launched successfully
    When user clicks on END Button 
    Then user verifies confirmation dialog for END PROGRAM and clicks on END PROGRAM button
    And user verifies the workout program is ended successfully




 

   
