package com.qa.pippintitle.testpages;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pippintitle.base.Base;
import com.qa.pippintitle.pages.DashBoardPage;
import com.qa.pippintitle.pages.LoginPage;
import com.qa.pippintitle.pages.OrderDetailsPage;
import com.qa.pippintitle.pages.PlaceNewOrderPage;
import com.qa.pippintitle.pages.ReviewOrderPage;

public class OrderDetailsPageTest {
	
	public Base basePageObj;
	public LoginPage loginPageObj;
	public DashBoardPage dashBoardPageObj;
	public PlaceNewOrderPage placeOrderObj;
	public ReviewOrderPage reviewOrderPageObj;
	public OrderDetailsPage orderDetailsPageObj;
	
	@BeforeMethod()
	public void navigateToDashBoardPage() throws InterruptedException, IOException
	{
		basePageObj = new Base();
		loginPageObj=basePageObj.launchBrowser();
		dashBoardPageObj=loginPageObj.clickLoginBtn();
		placeOrderObj=dashBoardPageObj.clickPlaceOrderBtn();
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
		reviewOrderPageObj=placeOrderObj.clickContinueButton();
		orderDetailsPageObj=reviewOrderPageObj.clickReviewPageSubmitBtn();
		
	}

	@Test()
	public void sendMessageTest()
	{
		orderDetailsPageObj.sendMessage();
		orderDetailsPageObj.logoutApplication();
	}

}
