@gmoTests
Feature: User verify text GMO Online on home page


   Scenario Outline: validate home page
   Given User is on home page
   Then User verify "<text>" on home page
   Then User logout from app
 
 Examples:
   		| text | 
   		| GMO OnLine | 
 
   
   Scenario: Verify 'Enter GMO OnLine' , 'About The GMO Site', and 'Browser Test Page'  buttons are visible and clickable.
   Given User is on home page
   And User verify mentioned buttons are visible on home page
   Then User logout from app
 
 
   Scenario: Verify 'Enter GMO OnLine' , 'About The GMO Site', and 'Browser Test Page'  buttons are clickable.
   Given User is on home page
   And User verify all buttons are clickable on home page
   Then User logout from app
 

   Scenario Outline: Verify using 'Reset Form'  user is able to Reset filled value for 'OnLine Catalog' form.
   Given User is on home page
   When User click on Enter GMO Online button
   Then User verify Reset Form is clickable on Online Catalog page
   And User enters quantity as "<quantity>" for 3person dome tent
   Then User Click on Reset Form button
   Then User verify field value is reset to 0
   Then User logout from app
   Examples:
   		| quantity | 
   		| 1 | 
   		| 100 | 
  
   Scenario Outline: Verify user is not able to place an order without selecting any products.
   Given User is on home page
   When User click on Enter GMO Online button
   And User click on Place an order button
   Then User verify alert text "<alert Text>" and click ok
   Then User logout from app
     Examples:
   		| alert Text | 
   		| Please Order Something First |
   		
   
   Scenario: Verify total 6 Item name is displayed on 'OnLine Catalog' form..
   Given User is on home page
   When User click on Enter GMO Online button
   Then User verify six items are displayed 
   Then User logout from app
     
 
   Scenario: Verify all items are clickable on Online Catalog page.
   Given User is on home page
   When User click on Enter GMO Online button
   Then User verify six items are clickable
   Then User logout from app
   
  
   Scenario Outline: Verify user can Place an Order  '3 Person Dome Tent' in quantity of 1. 
   Given User is on home page
   When User click on Enter GMO Online button
   And User enters quantity as "<quantity>" for 3person dome tent
   And User click on Place an order button
   Then User verify price of domeTent
   Then User logout from app
   Examples:
   		| quantity | 
   		| 1 | 
   		
   @test1
   Scenario Outline: Verify user can Place an Order after clicking proceed with Order button
   Given User is on home page
   When User click on Enter GMO Online button
   And User enters quantity as "<quantity>" for 3person dome tent
   And User click on Place an order button
   Then User click on Proceed with order button
   Then User logout from app
   Examples:
   		| quantity | 
   		| 1 | 
   		
   
   
   