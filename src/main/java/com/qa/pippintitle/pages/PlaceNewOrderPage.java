package com.qa.pippintitle.pages;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.pippintitle.base.Base;
import com.qa.pippintitle.utils.ScrollToCenterView;

public class PlaceNewOrderPage extends Base {
	
	
	@FindBy(xpath ="//*[contains(text(),'Common Products')]")
	WebElement commonProductsText;
	
	@FindBy(xpath="//*[@class='css-108wt49']")
	WebElement msgText;
	
	@FindBy(xpath="//*[@id='mat-radio-15']//*[text()='Full Search']")
	WebElement fullScreenRadioBtn;
	//*[text()='Full Search']
	
	//*[@id='mat-radio-15']//div[@class='mat-radio-container']
	//*[contains(text(),'Full Search')]
	
	
	@FindBy(xpath="//*[@id='mat-radio-21']//div[@class='mat-radio-outer-circle']")
	WebElement fullAddressRadioBtn;
	
	@FindBy(xpath="//*[@id='Property_First_Name']")
	WebElement ownerSellerName;
	
	@FindBy(xpath ="//*[contains(text(),'Search Criteria')]")
	WebElement searchCriteriaText;
	
	@FindBy(xpath="//*[@id='search-box']")
	WebElement addressSearch;
	
	@FindBy(xpath="//div[@class='pac-container pac-logo']")
	WebElement addressDropDownList;
	
	@FindBy(xpath="//div[@class='pac-container pac-logo']/div[2]")
	WebElement dropListTwo;
	
	@FindBy(xpath="//*[@id='Property_Order_Number']")
	WebElement clienReference;
	
	@FindBy(xpath="//*[@class='mat-icon-button _mat-animation-noopable']")
	WebElement mortageDateBtn;
	
	@FindBy(xpath="//button[@aria-label='Open calendar']")
	WebElement calenderIcon;
	
	
	@FindBy(xpath="//*[@id='mat-datepicker-0']")
	WebElement CalenderPopUp;
	
	@FindBy(xpath="//*//tr/td/div")
	List<WebElement> dates;
	
	@FindBy(xpath="//button[2][@class='btn btn-primary css-bnepv4']")
	WebElement uploadDocumentFile;
	//*[@id="orderForm"]/div/card-actions/div/h-stack/div/button[2]
	//button[contains(text(),'Upload Documents')]
	
	@FindBy(xpath="//*[@id=\"orderForm\"]/div/card-actions/div/h-stack/div/button[2]")
	WebElement uploadDocumentFile1;
	
	
	
	@FindBy(xpath="//label[contains(text(),'Documents')]/parent::div/div/div")
	List<WebElement> uploadedFileList;
	
	
	@FindBy(xpath ="//*[@class='modal-content']")
	WebElement deletePopUp;
	

	
	@FindBy(xpath="//*[@class='modal-content']//div/input[@id='conOk']")
	WebElement confirmBtn;
	
	
	@FindBy(xpath="//*[@class='preloader-full ng-star-inserted']//*[@class='ng-star-inserted']")
	WebElement loaderIcon;
	
	@FindBy(xpath="//button[@class='btn btn-primary css-1qdd7d0']")
	WebElement continueBtn;
	
	
	
	PlaceNewOrderPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickFullScreenRadioBtn()
	{
	
		boolean flag = true;
		while(flag==true)
		{
			new WebDriverWait(driver,10).until(ExpectedConditions.refreshed(
			        ExpectedConditions.elementToBeClickable(msgText)));
			try
			{
			boolean ajaxPopup = new WebDriverWait(driver,30).until(ExpectedConditions
					 .elementToBeClickable(msgText)) !=null;
			
			if(ajaxPopup==true)
	           {
				
				   new WebDriverWait(driver,10).until(ExpectedConditions.refreshed(
		   			        ExpectedConditions.elementToBeClickable(msgText)));
	        	   new Actions(driver).moveToElement(fullScreenRadioBtn).pause(1000).click().build().perform();
	        	
	        	   flag=false;
	           }
			}
			catch(Exception e)
			{
				System.out.println("The Exception caught is : :"+e);
				flag=true;
			}
		}

	}
			
	
	public void scrollToSearchCriteria() throws InterruptedException
	{
		boolean result = ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
		System.out.println(" Value of the Document Ready is : "+result);
		if(result) {ScrollToCenterView.scroll(searchCriteriaText);};
	
		
	}
	
	public void enterOwner_Seller_Name()
	{
		ownerSellerName.sendKeys("Test");
	}
	
	public void scrollToAddressSearch() throws InterruptedException
	{
		boolean result = ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
		if(result) {ScrollToCenterView.scroll(addressSearch);}
		
		
	}
	
	public void enterPropertyDetails()
	{
		//addressSearch.click();
		
		
		addressSearch.sendKeys("3485 Wineville");
	}
	
	public void waitForAddressPopUp() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(addressDropDownList));

		ScrollToCenterView.scroll(addressDropDownList);
	}
	
	public void selectDropDownSecondItem()
	{
		
		
		boolean result = ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
		if(result) {dropListTwo.click();}
		
		

		


	

	}

	public void enterClientreference()
	{
		ScrollToCenterView.scroll(clienReference);
		clienReference.sendKeys("TestClient");
	}
	
	
	public void selectClientDate() throws IOException
	{
		calenderIcon.click();
		new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(CalenderPopUp));
		
	
		String currentDate=new SimpleDateFormat("dd").format(new Date());
	
		for(int i=0;i<dates.size();i++)
		{
			if(dates.get(i).getText().equals(currentDate))
			{
				dates.get(i).click();
			}
		}
		
		
		
	}
	
	public void uploadDocument() throws IOException
	{
	
	for(int i =0;i<3;i++)
		{
			boolean result = ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			
			
			if(i<3)
			{
				new Actions(driver).moveToElement(uploadDocumentFile).click(uploadDocumentFile).build().perform();
				Runtime.getRuntime().exec(System.getProperty("user.dir")+"/fileUpload.exe "+System.getProperty("user.dir")+"\\test");
				
				
			}
			else
			{
				break;
			}
			
			new WebDriverWait(driver,15).until((ExpectedConditions.visibilityOf(loaderIcon)));
			
			
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
			
	}
	
	
	
	public void deleteUploadedFile()
	{
		if(uploadedFileList.size()>2)
		{
			for(int i =1; i<=uploadedFileList.size();i++)
			{
				driver.findElement(By.xpath("//label[contains(text(),'Documents')]/parent::div/div/div["+i+"]/button")).click();
			
				new WebDriverWait(driver,10).until((ExpectedConditions.elementToBeClickable(deletePopUp)));
				confirmBtn.click();
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
		}
	}
	
	
	
	
	
	
	public ReviewOrderPage clickContinueButton()
	{
		continueBtn.click();
		return new ReviewOrderPage();
	}
	
}
