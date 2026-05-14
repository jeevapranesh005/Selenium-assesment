package com.stepDefinition;

import org.testng.Assert;

import com.pages.AddressBookPage;
import com.pages.HomePage;
import com.pages.Searchpage;
import com.pages.loginpage;
import com.utilites.helper;
import java.util.Map;
import io.cucumber.datatable.DataTable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinition {

    Searchpage search;
    loginpage login;
    HomePage home;
    AddressBookPage address;

    @Given("the user is on the TutorialNinja website")
    public void the_user_is_on_the_tutorial_ninja_website() {

        helper.getdriver().get("https://tutorialsninja.com/demo/");

        login = new loginpage(helper.getdriver(), helper.wait);
        home = new HomePage(helper.getdriver(), helper.wait);
        search = new Searchpage(helper.getdriver(), helper.wait);
        address = new AddressBookPage(helper.getdriver(), helper.wait);
    }

    @When("the user clicks the My Account button")
    public void the_user_clicks_the_my_account_button() {
        login.myaccount();
    }

    @When("the user clicks the Login link")
    public void the_user_clicks_the_login_link() {
        login.loginlink();
    }

    @When("the user enters email {string} and password {string}")
    public void the_user_enters_email_and_password(String email, String password) {
        login.email(email);
        login.password(password);
    }

    @When("the user clicks the Login button")
    public void the_user_clicks_the_login_button() {
        login.loginButton();
    }

    @Then("the user should see the my account text")
    public void the_user_should_see_the_my_account_text() {
        String actual = home.homeAccount();
        String expected = "My Account";

        Assert.assertEquals(actual, expected);
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String keyword) {
        search.searchProduct(keyword);
    }

    @Then("the search result should {string}")
    public void the_search_result_should(String resultStatus) {
        if (resultStatus.equalsIgnoreCase("contain")) {
            Assert.assertTrue(search.isProductDisplayed(),"Product is not displayed");
        }
        else if (resultStatus.equalsIgnoreCase("not contain")) {
            Assert.assertTrue(search.isNoProductMessageDisplayed(),"No product message is not displayed");
        }
    }
    
    
    
    @When("the user navigates to Address Book page")
    public void the_user_navigates_to_address_book_page() {
        address.navigateToAddressBook();
    }

    @When("the user enters address details")
    public void the_user_enters_address_details(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        address.enterFirstName(data.get("firstname"));
        address.enterLastName(data.get("lastname"));
        address.enterAddress1(data.get("address1"));
        address.enterCity(data.get("city"));
        address.enterPostCode(data.get("postcode"));
        address.selectCountry(data.get("country"));
        address.selectRegion(data.get("region"));
    }

    @When("the user clicks the continue button")
    public void the_user_clicks_the_continue_button() {
        address.clickContinue();
    }

    @Then("the address should be added successfully")
    public void the_address_should_be_added_successfully() {
        Assert.assertTrue(address.successMessageDisplayed(),"Address was not added successfully");
    }
    
}