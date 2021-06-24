package com.qa.pippintitle.testpages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pippintitle.base.Base;
import com.qa.pippintitle.pages.LoginPage;

public class LoginPageTest extends Base{

	public Base basePageObj;
	public LoginPage loginPageObj;
	
	@BeforeMethod()
	public void launchBrowserTest()
	{
		basePageObj = new Base();
		loginPageObj=basePageObj.launchBrowser();
		
		
	}
	
	
	@Test
	public void clickLogionBtnTest()
	{
		loginPageObj.clickLoginBtn();
	}
}
