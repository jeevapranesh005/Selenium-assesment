package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebDriverWait mywait;
	
	public HomePage(WebDriver driver,WebDriverWait mywait) {
		this.driver=driver;
		this.mywait=mywait;
	}
	By myac = By.xpath("//h2[normalize-space()='My Account']");
	
	public String homeAccount() {
		return mywait.until(ExpectedConditions.visibilityOfElementLocated(myac)).getText();
	}
}
