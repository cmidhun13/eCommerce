package com.qa.pippintitle.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.pippintitle.base.Base;

public class ScrollToCenterView extends Base {

	public static void scroll(WebElement ele) 
	{
	
		

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ block:'center'})", ele);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ele);
//		Object innerHeight =	((JavascriptExecutor) driver).executeScript("return window.innerHeight");
//		
//	
//		
//		System.out.println("Size of Inner Window before scroll  :"+innerHeight);
//		System.out.println("Height of the Total Page "+((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight"));
//		
//		System.out.println("Height of the scroll bar position : "+((JavascriptExecutor) driver).executeScript("return document.body.pageYOffset;"));
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		Long value = (Long) executor.executeScript("return window.pageYOffset;");
//																						
//		System.out.println("Height of the scroll bar position : "+value);
//		
//		System.out.println("Size of Element before scroll : "+ele.getLocation().getY());
//		System.out.println("The Value of the Main Attribute :"+ele.getAttribute("style"));
		
		
//		
//		System.out.println("JQuery check status before execution :"+(((JavascriptExecutor) driver)
//                .executeScript("return jQuery.active == 0")));
//		
		
		
		
		
	//	new WebDriverWait(driver,5).until(ExpectedConditions.jsReturnsValue()
		
//		System.out.println("JQuery check status after execution  :"+(((JavascriptExecutor) driver)
//                    .executeScript("return jQuery.active == 0")));
		
		
		
		
		
//		System.out.println("The Value of the Main Attribute after scroll  :"+ele.getAttribute("style"));
//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		
		
		
		
//		
//		System.out.println("Position of the Element After scroll --->yAxis is : "+ele.getLocation().getY());
//		System.out.println("Position of the inner page size After scroll --->yAxis is : "+((JavascriptExecutor) driver).executeScript("return window.innerHeight"));
//		
		
//		((JavascriptExecutor) driver).executeScript("return window.scrollComplete;");
//		
	//	System.out.println(" Scroll status ; "+((JavascriptExecutor) driver).executeScript("return document.body.scrollComplete;"));
	
	}
	
}
