Feature: MailSend 
	As a user I want to send a message to given recipent
 

Scenario: As user with id 1 send mail message to recipent "test@t.pl" with message "test1" 
	Given I am a user with id 1 
	When As user 1 I send an email message with "test1" to recipent "test@t.pl" 
	Then I should recive response with status 200 
	When I filter all MessageOutputs by sender with id 1 
	Then I should have 1 message in filter result 
	And I should get a  messageoutput with message text "test1" and recipent "test@t.pl" 
