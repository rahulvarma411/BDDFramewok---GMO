package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.PredefinedActions;
import customExceptions.ElementNotEnabledException;

public class PlaceOrderPage extends PredefinedActions{
	
	@FindBy(xpath= "//tbody/tr[2]/td[4]")
	 private WebElement unitPriceForDometTentText;
	
	@FindBy(xpath= "//tbody/tr[2]/td[5]")
	 private WebElement totalPriceForDometTentText;
	
	@FindBy(name= "bSubmit")
	 private WebElement BtnProceedWithOrder;
	
	public PlaceOrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyPriceOfDomeTent() {
		String actualTotalPrice=totalPriceForDometTentText.getText();
		String expectedTotalPrice = "$ 299.99";
		Assert.assertEquals(expectedTotalPrice, actualTotalPrice);
		String actualUnitPrice=unitPriceForDometTentText.getText();
		String expectedUnitPrice = "$ 299.99";
		Assert.assertEquals(expectedUnitPrice, actualUnitPrice);	
	}
	
	public void ClickOnProceedWithOrderBtn() {
		 if(BtnProceedWithOrder.isEnabled()) {
			 BtnProceedWithOrder.click();
		 }
		 else {
			 throw new ElementNotEnabledException("element is not enabled");
		 }	 
	  }
    
	
	
	
	
	
	
	
}
