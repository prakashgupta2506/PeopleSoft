@test 
Feature: description of the story/epic

@scenario1 @reg  
Scenario: description of negative and  positive scenario.
Given i am fine
When thing is ok
Then verify that


@scenario2 @HookingTag  @reg
Scenario: scenario2  #hooking tag...we define the definition which will be called before executing this scenario..step definition is not generated automatically.. 
Given i am fine
When thing is ok
Then verify that

@scenario2  @reg
Scenario: scenario3
Given i am fine
When thing is ok
Then verify that

@scenario4 
Scenario: scenario4 
Given i am fine
When thing is ok
Then verify that