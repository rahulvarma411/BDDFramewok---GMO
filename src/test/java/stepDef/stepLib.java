package stepDef;

import org.junit.Assert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.OnlineCatalogPage;
import pages.PlaceOrderPage;
import pages.WelcomePage;


public class stepLib {
	
	@Given("^User is on home page$")
	public void user_is_on_home_page() {
		WelcomePage welcomePage=new WelcomePage();
	    welcomePage.initialization();
		
	}
	@Then("^User verify \"([^\"]*)\" on home page$")
	public void user_verify_on_home_page(String homePageText) {
		WelcomePage welcomePage=new WelcomePage();
        welcomePage.verifyTextOnHomePage(homePageText);
	}
	
	@And("^User verify mentioned buttons are visible on home page$")
	public void user_verify_mentioned_buttons_are_visible_on_home_page() throws Throwable {
		WelcomePage welcomePage=new WelcomePage();
		welcomePage.verifyVisibilityOfAllButtonsOnWecomePage();
	  
	}

     @Then("^User logout from app$")
     public void user_logout_from_app() throws Throwable {
     WelcomePage welcomePage=new WelcomePage();
	 welcomePage.tearDown();
     }
	
    @And("^User verify all buttons are clickable on home page$")
    public void user_verify_all_buttons_are_clickable_on_home_page() throws Throwable {
	WelcomePage welcomePage=new WelcomePage();
	welcomePage.verifyCickableAllButtonsOnWecomePage();
    }
    
    @When("^User click on Enter GMO Online button$")
    public void user_click_on_Enter_GMO_Online_button() throws Throwable {
    	WelcomePage welcomePage=new WelcomePage();
    	welcomePage.clickOnGMOOnineBtn();
    }
    @When("^User verify Reset Form is clickable on Online Catalog page$")
    public void user_verify_Reset_Form_is_clickable() throws Throwable {
    	OnlineCatalogPage onlineCatalogPage=new OnlineCatalogPage();
    	boolean flag=onlineCatalogPage.verifyClickableButtonResetFormOnOnlineCatalogPage(); 
    	Assert.assertTrue(flag);
    }
    
    @When("^User enters quantity as \"([^\"]*)\" for (\\d+)person dome tent$")
    public void user_enters_quantity_as_for_person_dome_tent(String arg1, int arg2) throws Throwable {
    	OnlineCatalogPage onlineCatalogPage=new OnlineCatalogPage();
    	onlineCatalogPage.enterQuantityForDomeTent("1"); 
    }
    

    @Then("^User verify six items are clickable$")
    public void user_verify_six_items_are_clickable() throws Throwable {
    	OnlineCatalogPage onlineCatalogPage=new OnlineCatalogPage();
    	onlineCatalogPage.veifyClickableTableElements();
    }


    @Then("^User Click on Reset Form button$")
    public void user_Click_on_Reset_Form_button() throws Throwable {
    	OnlineCatalogPage onlineCatalogPage=new OnlineCatalogPage();
    	onlineCatalogPage.ClickOnResetFormBtn();
    }
    
    @Then("^User verify field value is reset to (\\d+)$")
    public void user_verify_field_value_is_reset_to(String arg1) throws Throwable {
    	OnlineCatalogPage onlineCatalogPage=new OnlineCatalogPage();
    	onlineCatalogPage.verifyFieldValueIsReset("0");
    }
    @And("^User click on Place an order button$")
    public void user_click_on_Place_an_order_button() throws Throwable {
    	OnlineCatalogPage onlineCatalogPage=new OnlineCatalogPage();
    	onlineCatalogPage.ClickOnPlaceAnOrderBtn();
    }

    @Then("^User verify alert text \"([^\"]*)\" and click ok$")
    public void user_verify_alert_text_and_click_ok(String alertText) throws Throwable {
    	OnlineCatalogPage onlineCatalogPage=new OnlineCatalogPage();
    	onlineCatalogPage.handleAlert(alertText);
    }

    @Then("^User verify six items are displayed$")
    public void user_verify_six_items_are_displayed() throws Throwable {
    	OnlineCatalogPage onlineCatalogPage=new OnlineCatalogPage();
    	onlineCatalogPage.getTableElements();
    }

    @Then("^User verify price of domeTent$")
    public void user_verify_price_of_domeTent() throws Throwable {
    	PlaceOrderPage 	placeOrderPage=new PlaceOrderPage();
    	placeOrderPage.verifyPriceOfDomeTent();
    }
    
    @Then("^User click on Proceed with order button$")
    public void user_click_on_Proceed_with_order_button() throws Throwable {
    	PlaceOrderPage 	placeOrderPage=new PlaceOrderPage();
    	placeOrderPage.ClickOnProceedWithOrderBtn();
    }

    


	
}
