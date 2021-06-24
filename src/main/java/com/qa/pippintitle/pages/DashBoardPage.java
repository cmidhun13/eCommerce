package com.qa.pippintitle.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.pippintitle.base.Base;

public class DashBoardPage extends Base {
	
	
	@FindBy(xpath="//*[contains(text(),'Place Order')]")
	public WebElement placeOrderBtn;
	
	
	DashBoardPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public PlaceNewOrderPage clickPlaceOrderBtn()
	{
		
		new WebDriverWait(driver,15).until(ExpectedConditions.elementToBeClickable(placeOrderBtn));
		new Actions(driver).moveToElement(placeOrderBtn).click().build().perform();
		placeOrderBtn.click();
		return new PlaceNewOrderPage();
	}

}
