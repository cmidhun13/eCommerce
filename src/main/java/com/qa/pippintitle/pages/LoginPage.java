package com.qa.pippintitle.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.pippintitle.base.Base;

public class LoginPage extends Base {
	
	
	
	@FindBy(xpath="//input[@id='Email_Address']")
	public WebElement email;
	
	@FindBy(xpath="//input[@id ='User_Password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@id='loginBtnLogin']")
	public WebElement loginBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public DashBoardPage clickLoginBtn()
	{
		email.sendKeys("pippintitle_demotest@mailinator.com");
		password.sendKeys("DemoTest#567#");
		loginBtn.click();
		return new DashBoardPage();
	}
	
	

}
