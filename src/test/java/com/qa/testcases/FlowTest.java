package com.qa.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.FlowPages;
import com.qa.pages.SideMenuPage;

import io.appium.java_client.android.AndroidDriver;

public class FlowTest extends TestBase {
	
	public AndroidDriver mobileDriver;
	
	@BeforeMethod
	public void initialize(){
		mobileDriver=initializeDriver();
	}
	
	@Test(description="Verify context under Help")
	public void verifyHelp()throws MalformedURLException,InterruptedException{
		FlowPages fp =new FlowPages(mobileDriver);
		Thread.sleep(20);
		fp.clickAcceptButton();
		SideMenuPage sp=fp.clickSideMenu();
		sp.selectHelpAndFeedback();
		Assert.assertTrue(sp.verifyHelpOnDocumentationIsDisplayed(), "Help context - Help on Documentation");
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown(ITestResult tearResult) {
		this.mobileDriver.quit();
	}
	
}
