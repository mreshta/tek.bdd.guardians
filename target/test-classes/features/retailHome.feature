Feature: Retail Home Page

Background:
	Given User is on retail website homepage
@verifySideBar
Scenario: Verify Shop by Department sidebar
	When User click on All section
	Then below options are present in Shop by Department sidebar
	|Electronics|Computers|Smart Home|Sports|Automative|