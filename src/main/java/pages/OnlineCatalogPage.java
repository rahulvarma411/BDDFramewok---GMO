package pages;
import java.util.ArrayList;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.PredefinedActions;
import customExceptions.ElementNotEnabledException;

public class OnlineCatalogPage extends PredefinedActions{

	@FindBy(xpath= "//input[@type='text' and @name='QTY_TENTS']")
	 private WebElement domeTentQuantityTextBox;
	
	@FindBy(name= "bReset")
	 private WebElement BtnresetForm;
	
	@FindBy(name= "bSubmit")
	 private WebElement BtnPlaceAnOrder;
	
	public OnlineCatalogPage() {
		PageFactory.initElements(driver, this);
	}
	
	 public boolean verifyClickableButtonResetFormOnOnlineCatalogPage() {
			try {
			return BtnresetForm.isEnabled(); 
			}
			catch (ElementNotEnabledException ne) {	
				return false;
			}	
		}
	 
	 public void enterQuantityForDomeTent(String value) {
			if (domeTentQuantityTextBox.isEnabled()) {
				domeTentQuantityTextBox.sendKeys(value);
			} else {
				throw new ElementNotEnabledException("textBox is not enabled");
			}

		}
	 
	 public void ClickOnResetFormBtn() {
		 if(BtnresetForm.isEnabled()) {
			 BtnresetForm.click();
		 }
		 else {
			 throw new ElementNotEnabledException("element is not enabled");
		 }	 
	  }
	 
	 public void verifyFieldValueIsReset(String expected) {
		String actual= domeTentQuantityTextBox.getAttribute("value");
		Assert.assertEquals(expected, actual);
	 }
	 
	 public void ClickOnPlaceAnOrderBtn() {
		 if(BtnPlaceAnOrder.isEnabled()) {
			 BtnPlaceAnOrder.click();
		 }
		 else {
			 throw new ElementNotEnabledException("element is not enabled");
		 }	 
	  }
	 
	 public void handleAlert(String alertText) {
		 
		Alert alert= driver.switchTo().alert();
		String actual=alert.getText();
		Assert.assertEquals(actual,alertText);
		alert.accept();
	 }
	 
	 public void getTableElements(){
			ArrayList<String> al = new ArrayList<String>();

			int size = driver.findElements(By.xpath("//table/tbody/tr/td/a")).size();
			System.out.println("Count of Items: " + size);

			for (int i = 2; i <= size + 1; i++) {

				String itemName = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td/a")).getText();
                System.out.println(itemName);
				al.add(itemName);
				
			}
				int actual = al.size();
				int expected = 6;
				Assert.assertEquals(actual, expected);

			}

	 public void veifyClickableTableElements() {

			int size = driver.findElements(By.xpath("//table/tbody/tr/td/a")).size();
			System.out.println("Count of Items: " + size);

			for (int i = 2; i <= size + 1; i++) {

				boolean flag=driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td/a")).isEnabled();
				Assert.assertTrue(flag);			
			}		
	 }
		}