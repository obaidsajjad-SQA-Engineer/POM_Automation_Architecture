package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class SideMenuPage {
	
	public AndroidDriver mobileDriver;
	
	@FindBy(xpath="//android.widget.CheckedTextView[@resource-id=\"com.llamalab.automate:id/design_menu_item_text\" and @text=\"Help & feedback\"]")
	@CacheLookup
	WebElement helpAndFeedback;
	
	public SideMenuPage(AndroidDriver mobileDriver) {
		this.mobileDriver=mobileDriver;
		PageFactory.initElements(mobileDriver, this);
	}
	
	public void selectHelpAndFeedback() {
		try {
			helpAndFeedback.click();
		}catch(Exception e){
			throw new RuntimeException("Unable to select HelpAndFeedback");
		}
	}

	public boolean verifyHelpOnDocumentationIsDisplayed() {
		WebDriverWait wait = new WebDriverWait(mobileDriver, Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Documentation\"]")));
		try {
           return true;
        } catch (Exception e) {
            throw new RuntimeException("Help context - Help on Documentation is not displayed.", e);
        }
	}

}
