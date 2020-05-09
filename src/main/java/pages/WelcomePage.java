package pages;

import java.util.NoSuchElementException;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.PredefinedActions;
import customExceptions.ElementNotEnabledException;

public class WelcomePage extends PredefinedActions {
	
	@FindBy(xpath= "//font[text()='GMO OnLine']")
	 private WebElement textGMOOnline;

	@FindBy(name= "bSubmit")
	 private WebElement btnEnterGMOOnline;
	
	@FindBy(name= "bAbout")
	 private WebElement btnAboutGMOSite;
	
	@FindBy(name= "bBrowserTest")
	 private WebElement btnBrowserTestPage;
	
	
	
	//resetFormBtn=[xpath]:-//input[@name='bReset']
	
	public WelcomePage() {
		PageFactory.initElements(driver, this);
	}
	public void verifyTextOnHomePage(String text_GMOOnline) {
		String actualText=textGMOOnline.getText();
		System.out.println(actualText);
		Assert.assertEquals(text_GMOOnline, actualText);
	}
	
	private boolean verifyVisibilityOfButtonAboutGMOSiteOnWecomePage() {
		try {
			return btnAboutGMOSite.isDisplayed();
		}
		catch (NoSuchElementException ne) {
			return false;
		}
	}
	
	private boolean verifyVisibilityOfButtonBrowserTestPageOnWecomePage() {
		try {
			return btnBrowserTestPage.isDisplayed();
		}
		catch (NoSuchElementException ne) {
			return false;
		}
	}
	
	private boolean verifyVisibilityOfButtonEnterGMOOnlineOnWecomePage() {
		try {
			return btnEnterGMOOnline.isDisplayed();
		}
		catch (NoSuchElementException ne) {
			return false;
		}
	}
	private boolean verifyClickableButtonEnterGMOOnlineOnWecomePage() {
		try {
			return btnEnterGMOOnline.isEnabled();
		}
		catch (ElementNotEnabledException ne) {
			return false;
		}
	}
	private boolean verifyClickableButtonBrowserTestPageOnWecomePage() {
		try {
			return btnBrowserTestPage.isEnabled();
		}
		catch (ElementNotEnabledException ne) {
			return false;
		}
	}
	private boolean verifyClickableButtonAboutGMOSiteOnWecomePage() {
		try {
			return btnAboutGMOSite.isEnabled();
		}
		catch (ElementNotEnabledException ne) {
			return false;
		}
	}
	public void verifyVisibilityOfAllButtonsOnWecomePage() {
		boolean flag1=verifyVisibilityOfButtonBrowserTestPageOnWecomePage();
		boolean flag2=verifyVisibilityOfButtonEnterGMOOnlineOnWecomePage();
		boolean flag3=verifyVisibilityOfButtonAboutGMOSiteOnWecomePage();
		
		Assert.assertTrue(flag1);
		Assert.assertTrue(flag2);
		Assert.assertTrue(flag3);
	}
	
	public void verifyCickableAllButtonsOnWecomePage() {
		boolean flag1=verifyClickableButtonBrowserTestPageOnWecomePage();
		boolean flag2=verifyClickableButtonEnterGMOOnlineOnWecomePage();
		boolean flag3=verifyClickableButtonAboutGMOSiteOnWecomePage();
		
		Assert.assertTrue(flag1);
		Assert.assertTrue(flag2);
		Assert.assertTrue(flag3);
	}
	 public void clickOnGMOOnineBtn() {
		 if(btnEnterGMOOnline.isEnabled()) {
			 btnEnterGMOOnline.click();
		 }
		 else {
			 throw new ElementNotEnabledException("element is not enabled");
		 }	 
	 }
	 
	
	
	
}
