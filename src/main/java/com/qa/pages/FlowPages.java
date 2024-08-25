package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

import io.appium.java_client.android.AndroidDriver;

public class FlowPages extends TestBase {
	
	public AndroidDriver mobileDriver;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
    @CacheLookup
    WebElement acceptBtn;
	
	@FindBy(xpath="//android.widget.ImageButton[@content-desc=\"Open drawer\"]")
	@CacheLookup
	WebElement sideMenuBtn;
	
	public FlowPages(AndroidDriver mobileDriver)
	{
		this.mobileDriver=mobileDriver;
		PageFactory.initElements(mobileDriver, this);
	}

	public void clickAcceptButton() {
		try {
			acceptBtn.click();
		}catch(Exception e){
			throw new RuntimeException("Unable to click on Accept Button");
		}
	}

	public SideMenuPage clickSideMenu() {
		try {
			sideMenuBtn.click();
			return new SideMenuPage(mobileDriver);
		}catch(Exception e){
			throw new RuntimeException("Unable to click on Side Menu");
		}
	}
	
}
