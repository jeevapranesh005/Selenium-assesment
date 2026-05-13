package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginpage {
	WebDriver driver;
	WebDriverWait mywait;
	
	public loginpage(WebDriver driver,WebDriverWait mywait) {
		this.driver=driver;
		this.mywait=mywait;	
		}
	
	By myaccount = By.xpath("//span[normalize-space()='My Account']");
	By login = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']");
	By email = By.xpath("//input[@id='input-email']");
	By password = By.xpath("//input[@id='input-password']");
	By loginButton = By.xpath("//input[@value='Login']");
	
	
	public void myaccount() {
		mywait.until(ExpectedConditions.visibilityOfElementLocated(myaccount)).click();
	}
	public void loginlink() {
		mywait.until(ExpectedConditions.visibilityOfElementLocated(login)).click();
	}
	public void email(String str) {
		mywait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(str);
	}
	public void password(String str) {
		mywait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(str);
	}
	public void loginButton() {
		mywait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
	}
}
