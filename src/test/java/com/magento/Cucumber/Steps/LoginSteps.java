package com.magento.Cucumber.Steps;

import com.magento.TestCases.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class LoginSteps extends BaseTest {


    @Before
    public void setUpCucumber() {
        setUp("chrome", "qa");

    }

    @After
    public void tearDownCucumber() {
        driver.quit();
    }

    @Given("I navigate to the login page")
    public void i_navigate_to_the_login_page() {
        header.getLogingPage();
    }

    @When("I enter email and password")
    public void i_enter_email_and_password() {
        loginPage.setEmail(configReader.getProperty("email"));
        loginPage.setPassword(configReader.getProperty("password"));
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.login();
    }

    @Then("I should see the home page")
    public void i_should_see_the_home_page() {
        Assert.assertEquals(driver.getTitle(), "Home Page", "Title not correctly");
        Assert.assertEquals(driver.getCurrentUrl(), configReader.getProperty("baseUrl"), "Url not correct");

    }


}
