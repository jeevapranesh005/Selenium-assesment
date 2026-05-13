package com.utilites;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class helper {

    public static ThreadLocal<WebDriver> driver1 = new ThreadLocal<>();

    public static WebDriverWait wait;

    public void setup() {
        driver1.set(new ChromeDriver());
        getdriver().manage().window().maximize();
        getdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(getdriver(),  Duration.ofSeconds(10));
    }

    public static WebDriver getdriver() {
        return driver1.get();
    }

    public void end() {
        if (getdriver() != null) {
            getdriver().quit();
            driver1.remove();
        }
    }
}