package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressBookPage {

    WebDriver driver;
    WebDriverWait mywait;

    public AddressBookPage(WebDriver driver, WebDriverWait mywait) {

        this.driver = driver;
        this.mywait = mywait;
    }

    By addressBook = By.linkText("Address Book");
    By newAddress = By.linkText("New Address");

    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By address1 = By.id("input-address-1");
    By city = By.id("input-city");
    By postcode = By.id("input-postcode");

    By country = By.id("input-country");
    By region = By.id("input-zone");

    By continueButton = By.xpath("//input[@value='Continue']");

    By successMessage = By.xpath("//div[contains(@class,'alert-success')]");

    public void navigateToAddressBook() {
        mywait.until(ExpectedConditions.elementToBeClickable(addressBook)).click();
        mywait.until(ExpectedConditions.elementToBeClickable(newAddress)).click();
    }

    public void enterFirstName(String value) {
        driver.findElement(firstName).sendKeys(value);
      
 }

    public void enterLastName(String value) {
        driver.findElement(lastName).sendKeys(value);
    	}

    public void enterAddress1(String value) {
        driver.findElement(address1).sendKeys(value);
    		}	

    public void enterCity(String value) {
        driver.findElement(city).sendKeys(value);
   }

    public void enterPostCode(String value) {
        driver.findElement(postcode).sendKeys(value);
    }

    public void selectCountry(String value) {
        Select select = new Select(driver.findElement(country));
        select.selectByVisibleText(value);
    }

    public void selectRegion(String value) {
        Select select = new Select(driver.findElement(region));
        select.selectByVisibleText(value);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public boolean successMessageDisplayed() {
        return driver.findElements(successMessage).size() > 0;
    }
}