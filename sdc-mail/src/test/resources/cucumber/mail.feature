Feature: Sending mails and filtering mails tests 

Scenario: As user with id 1 i want to get all output messages that was send by user 3 
	Given User 3 send an email with text "test1" and recipent "test@t.pl" 
	When I filter all MessageOutputs by sender with id 3 
	Then I should have 1 message in filter result 
	Then I should get a  messageoutput with message text "test1" and recipent "test@t.pl" 
	
Scenario: As user with id 1 send mail message to recipent "test@t.pl" with message "test1" 
	Given I am a user with id 1 
	When I filter all MessageOutputs by sender with id 1
	Then I should have 0 message in filter result 
	When As user 1 I send an email message with "test2" to recipent "test2@t.pl" 
	Then I should recive response with status 200 
	When I filter all MessageOutputs by sender with id 1 
	Then I should have 1 message in filter result 
	And I should get a  messageoutput with message text "test2" and recipent "test2@t.pl" 
	
