@UI
Feature: This feature is verify Plan settings for different work out days 

Background:
Given user launch the Gymondo url
And user logs into Gymondo app with valid credentials

@workoutsettings     
Scenario Outline: Verify user can set plan settings for any combination of weekdays and it should reflect in calendar as well as per the settings    
    Given user verifies successful login page for Gymondo home page
    And user opens plan settings
    And user verifies that plan settings is launched successfully
    When user sets following workout days "<Mon>","<Tue>","<Wed>","<Thu>","<Fri>","<Sat>" and "<Sun>"
    And user saves the workout settings
    Then user verifies following workout days "<Mon>","<Tue>","<Wed>","<Thu>","<Fri>","<Sat>" and "<Sun>" are updated in the calendar
    And user logs out of Gymondo app 
    
Examples:
|Mon	|Tue		|Wed		|Thu		|Fri	|Sat		|Sun	|
|NO 	|YES		|YES		|NO			|NO 	|NO			|YES	|
|YES 	|NO			|YES		|NO			|NO 	|YES		|NO		|
|NO 	|YES		|NO			|YES		|NO 	|NO			|YES	|
|YES 	|YES		|YES		|NO			|YES 	|NO			|YES	|

