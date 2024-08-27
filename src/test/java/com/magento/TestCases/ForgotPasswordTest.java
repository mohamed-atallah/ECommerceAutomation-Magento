package com.magento.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTest{
    @Test
    public void testInvalidEmail() {
        header.getLogingPage();
        loginPage.forgotPassword();
        // Enter invalid email
        forgotPasswordPage.enterEmail("invalid-email");
        forgotPasswordPage.clickResetPasswordButton();
        // Validate the error message
        String errorMessage = forgotPasswordPage.getEmailErrorMessage();
        Assert.assertEquals(errorMessage, "Please enter a valid email address (Ex: johndoe@domain.com).", "Error message is not as expected");
    }

    @Test
    public void testEmptyEmail() {
        header.getLogingPage();
        loginPage.forgotPassword();
        // Leave the email field empty and submit
        forgotPasswordPage.enterEmail("");
        forgotPasswordPage.clickResetPasswordButton();

        // Validate the error message
        String errorMessage = forgotPasswordPage.getEmailErrorMessage();
        Assert.assertEquals(errorMessage, "This is a required field.", "Error message is not as expected");
    }

    @Test
    public void testValidEmail() {
        header.getLogingPage();
        loginPage.forgotPassword();
        // Enter a valid email and submit the form
        forgotPasswordPage.enterEmail("test@example.com");
        forgotPasswordPage.clickResetPasswordButton();
        String expectedMessage = "If there is an account associated with test@example.com you will receive an email with a link to reset your password.";
        String actualMessage = loginPage.getSuccessMessageText();
        Assert.assertEquals(actualMessage, expectedMessage, "Success message is not as expected.");
        Assert.assertTrue(driver.getCurrentUrl().contains("login/referer/"),
                "Password reset request was not submitted successfully.");

    }

}
