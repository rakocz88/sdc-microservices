Feature: User Feature

Scenario: I want to registrate a new user and then activate it with a code
	Given I am a user with no account
	When I fill the user data with login= "test1" and password= "pass1" and firstname = "name1" and surname = "surname1" and email= "filip.radziejewski2@gmail.com"
	And I send a requets to the server with the date i filled
	Then I should get a response 200
	And I should recieve an email with the code to activate the user on the address "filip.radziejewski2@gmail.com"
	And The code in the email should be present in the code repository for the user "test1" and it should not be terminated
	And The user "test1" should exist and have the filds pass= "pass1" , firstname = "name1" , surname = "surname1" 
	And the user "test1" should not be active
	When The user "test1" send the activation code to the server
	Then The user "test1" should be active
	
