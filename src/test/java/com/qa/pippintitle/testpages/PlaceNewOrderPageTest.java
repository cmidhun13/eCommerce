package com.qa.pippintitle.testpages;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pippintitle.base.Base;
import com.qa.pippintitle.pages.DashBoardPage;
import com.qa.pippintitle.pages.LoginPage;
import com.qa.pippintitle.pages.PlaceNewOrderPage;
import com.qa.pippintitle.utils.ScrollToCenterView;

public class PlaceNewOrderPageTest {
	

	public Base basePageObj;
	public LoginPage loginPageObj;
	public DashBoardPage dashBoardPageObj;
	public PlaceNewOrderPage placeOrderObj;
	
	@BeforeMethod()
	public void navigateToDashBoardPage()
	{
		basePageObj = new Base();
		loginPageObj=basePageObj.launchBrowser();
		dashBoardPageObj=loginPageObj.clickLoginBtn();
		placeOrderObj=dashBoardPageObj.clickPlaceOrderBtn();
		
	}
	
	
	@Test
	public void clickContinueBtn() throws InterruptedException, IOException
	{
		placeOrderObj.clickFullScreenRadioBtn();
		placeOrderObj.scrollToSearchCriteria();
		placeOrderObj.enterOwner_Seller_Name();
		placeOrderObj.scrollToAddressSearch();
		placeOrderObj.enterPropertyDetails();
		placeOrderObj.waitForAddressPopUp();
		placeOrderObj.selectDropDownSecondItem();
		placeOrderObj.enterClientreference();
		placeOrderObj.selectClientDate();
		placeOrderObj.uploadDocument();
		placeOrderObj.deleteUploadedFile();
		placeOrderObj.clickContinueButton();
	}

}
