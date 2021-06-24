package com.qa.pippintitle.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import com.qa.pippintitle.base.Base;
import com.qa.pippintitle.utils.ScrollToView;

public class OrderDetailsPage extends Base{
	
	
	@FindBy(xpath="//*[contains(text(),'Order Details')]")
	WebElement pageTitle;
	
	@FindBy(xpath="//*[@class='pb-5 px-5 pt-1']//div[@class='row pt-1']/div//input")
	List<WebElement> orderItemList;
	
	@FindBy(xpath="//*[@class='modal-content']")
	WebElement msgPopUpBox;
	
	
	@FindBy(xpath="//*[@class='modal-content']//*[@id='msg-area']")
	WebElement msgTextArea;
	
	
	@FindBy(xpath="//*[@class='modal-content']//input[@id='msgSend']")
	WebElement msgSendBtn;
	
	@FindBy(xpath="//input[@id='ordDetBtnSendMsg']")
	WebElement messageBtn;
	
	@FindBy(xpath="//*[@class='preloader-full ng-star-inserted']//*[@class='ng-star-inserted']")
	WebElement loaderIcon;
	
	@FindBy(xpath="//button[@class='mat-button css-bnepv4 _mat-animation-noopable']")
	WebElement logoutArrowBtn;
	//icon='arrow_drop_down'
	
	@FindBy(xpath="//*[@class='mat-menu-content']")
	WebElement logoutDropBox;
	
	@FindBy(xpath="//*[@class='mat-menu-content']//button[contains(text(),'Logout')]")
	WebElement logoutItem;
	
	
	
	OrderDetailsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void sendMessage()
	{
		ScrollToView.scroll(pageTitle);
		new Actions(driver).moveToElement(messageBtn).pause(2000).click().build().perform();
	
		new WebDriverWait(driver,15).until(ExpectedConditions.elementToBeClickable(msgPopUpBox));
		msgTextArea.click();
		for(int i=0;i<orderItemList.size();i++)
		{
			msgTextArea.sendKeys(orderItemList.get(i).getAttribute("value"));
			msgTextArea.sendKeys(Keys.ENTER);
			
		}
		msgSendBtn.click();
		new WebDriverWait(driver,10).until((ExpectedConditions.visibilityOf(loaderIcon)));
		
		
		boolean flag = true;
		
		while(flag==true)
		{
			List<WebElement> loader1=
					driver.findElements(By.xpath("//*[@class='preloader-full ng-star-inserted']//*[@class='ng-star-inserted']"));
			
		
			if(loader1.size()==0)
			{
				flag=false;
				
				
			}
		}
		
	}
	
	public void logoutApplication()
	{
		      
		
		   new Actions(driver).moveToElement(logoutArrowBtn).pause(2000).click().build().perform();
		   
		   new WebDriverWait(driver,15).until(ExpectedConditions.elementToBeClickable(logoutDropBox));
		   
		   new Actions(driver).moveToElement(logoutItem).pause(2000).click().build().perform();
		   
		   
	}
}
