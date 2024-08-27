package com.magento.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage{
    /**
     * Constructor to initialize various WebDriver-related utilities and components.
     * This constructor takes a WebDriver instance and sets up the following:
     * 1. Initializes the WebDriver instance for the page.
     * 2. Initializes WebDriver.Navigation for browser navigation actions.
     * 3. Initializes WebDriverWait with a 10-second timeout for waiting on elements or conditions.
     * 4. Initializes the Actions class for simulating complex user gestures.
     * 5. Initializes the PageFactory to locate and initialize all WebElements in this page object.
     *
     * @param driver WebDriver instance to be used across this page object.
     */
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }
    // Locator for the email input field
    @FindBy(id = "email_address")
    WebElement emailInput;

    // Locator for the reset password button
    @FindBy(css = "button.action.submit.primary")
    WebElement resetPasswordButton;

    // Locator for the error message
    @FindBy(id = "email_address-error")
    WebElement emailErrorMessage;

    // Method to input email
    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    // Method to click the reset password button
    public void clickResetPasswordButton() {
        resetPasswordButton.click();
    }

    // Method to get the error message text
    public String getEmailErrorMessage() {
        return emailErrorMessage.getText();
    }
}
