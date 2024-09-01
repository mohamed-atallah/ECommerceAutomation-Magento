package com.magento.TestCases;

import com.magento.DataProvider.LoginDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test(dataProvider = "invalidLoginData", dataProviderClass = LoginDataProvider.class)
    @Owner("Mohamed Atallah ")
    @Link(name = "Login Page", url = "https://example.com")
    @Description("Login with invalid email and password")
    public void testInvalidLogin(String email, String password) {
        // Use email and password from the data provider
        header.getLogingPage();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.login();
        String errorMessage = loginPage.getMessage();
        System.out.println("Message: " + errorMessage);
        Assert.assertTrue(errorMessage.contains("try again"), "The error message does not contain the expected text.");
    }

    @Test
    public void testLoginWithoutPassword() {
        header.getLogingPage();
        loginPage.setEmail("test@gmail.com");
        loginPage.setPassword("");
        loginPage.login();
        System.out.println("Message : " + loginPage.getMessagePassError());
        Assert.assertTrue(loginPage.getMessagePassError().contains("required"));
    }

    @Test(dataProvider = "getLoginDataWithoutEmail", dataProviderClass = LoginDataProvider.class)
    public void testLoginWithoutEmail(String email, String password) {
        header.getLogingPage();
        loginPage.setPassword(password);
        loginPage.setEmail(email);
        loginPage.login();
        System.out.println("Message : " + loginPage.getMessageEmailError());
        Assert.assertTrue(loginPage.getMessageEmailError().contains("required"));

    }

    @Test
    public void testTitleLoginPage() {
        loginPage = header.getLogingPage();
        Assert.assertEquals(driver.getTitle(), "Customer Login", "Title not correctly");

    }

    @Test
    public void testRedirectForgotPassword() {
        header.getLogingPage();
        loginPage.forgotPassword();
        Assert.assertEquals(driver.getTitle(), "Forgot Your Password?", "Title not correctly");
        Assert.assertEquals(driver.getCurrentUrl(), "https://magento.softwaretestingboard.com/customer/account/forgotpassword/", "Url not correct");
    }

    @Test
    public void testRedirectRegister() {
        header.getLogingPage();
        loginPage.register();
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account", "Title not correctly");
        Assert.assertEquals(driver.getCurrentUrl(), "https://magento.softwaretestingboard.com/customer/account/create/", "Url not correct");
    }

    @Test(priority = 50)
    public void testLoginSuccessfully() {
        header.getLogingPage();
        loginPage.setEmail(configReader.getProperty("email"));
        loginPage.setPassword(configReader.getProperty("password"));
        loginPage.login();
        Assert.assertEquals(driver.getTitle(), "My Account", "Title not correctly");
        Assert.assertEquals(driver.getCurrentUrl(), configReader.getProperty("baseUrl"), "Url not correct");
    }

}
