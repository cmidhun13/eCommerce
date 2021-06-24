package com.qa.pippintitle.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.pippintitle.base.Base;

public class ReviewOrderPage extends Base {
	
	
	@FindBy(xpath="//*[@class='preloader-full ng-star-inserted']//*[@class='ng-star-inserted']")
	WebElement loaderIcon;
	
	@FindBy(xpath="//div[@class='css-y5t6v6']/h5")
	WebElement pageHeader;
	
	
	@FindBy(xpath="//label[@class='mat-checkbox-layout']")
	WebElement acceptCheckBox;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	WebElement submitBtn;
	
	ReviewOrderPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public OrderDetailsPage clickReviewPageSubmitBtn()
	{
		
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
		
		new WebDriverWait(driver,15).until(ExpectedConditions.elementToBeClickable(pageHeader));
		
	
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		Long pageHeight = (Long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
		Long clientHeight =(Long)((JavascriptExecutor) driver).executeScript("return document.documentElement.clientHeight");
	
		while(true)
		{
			Long pageYOffSet = (Long)((JavascriptExecutor) driver).executeScript("return window.pageYOffset;");

			((JavascriptExecutor) driver)
		     .executeScript("window.scrollTo(0,document.body.scrollHeight)");
			
			if((pageYOffSet+clientHeight)==pageHeight)
			{
				
				break;
			}
		}
	
		acceptCheckBox.click();
		submitBtn.click();
		return new OrderDetailsPage();
	}
	
	
	

}
