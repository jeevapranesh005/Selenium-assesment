package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Searchpage {

    WebDriver driver;
    WebDriverWait mywait;

    public Searchpage(WebDriver driver, WebDriverWait mywait) {
        this.driver = driver;
        this.mywait = mywait;
    }

    By search = By.xpath("//input[@placeholder='Search']");
    By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']");
    By productResult = By.xpath("//div[@class='product-thumb']");
    By noProductMessage = By.xpath("//p[contains(text(),'There is no product that matches the search criteria.')]");

    public void searchProduct(String product) {
        mywait.until(ExpectedConditions.visibilityOfElementLocated(search)).clear();
        mywait.until(ExpectedConditions.visibilityOfElementLocated(search)).sendKeys(product);
        mywait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public boolean isProductDisplayed() {
        return driver.findElements(productResult).size() > 0;
    }

    public boolean isNoProductMessageDisplayed() {
        return driver.findElements(noProductMessage).size() > 0;
    }
}