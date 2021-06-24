package com.qa.pippintitle.testpages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pippintitle.base.Base;
import com.qa.pippintitle.pages.DashBoardPage;
import com.qa.pippintitle.pages.LoginPage;

public class DashBoardPageTest extends Base {

	public Base basePageObj;
	public LoginPage loginPageObj;
	public DashBoardPage dashBoardPageObj;
	
	@BeforeMethod()
	public void navigateToDashBoardPage()
	{
		basePageObj = new Base();
		loginPageObj=basePageObj.launchBrowser();
		dashBoardPageObj=loginPageObj.clickLoginBtn();
		
	}
	@Test()
	public void clickPlaceOrderBtn()
	{
		dashBoardPageObj.clickPlaceOrderBtn();
	}
	
	
	
}
