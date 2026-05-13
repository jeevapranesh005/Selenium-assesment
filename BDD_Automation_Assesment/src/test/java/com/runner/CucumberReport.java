package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = {"src/test/resources/Feature/Search.feature","src/test/resources/Feature/AddressBook.feature"},
        glue = { "com.stepDefinition","com.Hooks"},
        plugin = {"pretty","html:target/cucumber-report.html",
        		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", 
        		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
)

public class CucumberReport extends AbstractTestNGCucumberTests {

}