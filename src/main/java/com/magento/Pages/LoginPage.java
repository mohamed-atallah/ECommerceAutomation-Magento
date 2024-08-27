package com.magento.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    WebElement EmailField;
    @FindBy(id = "pass")
    WebElement PasswordField;
    @FindBy(id = "send2")
    WebElement LoginButton;
    @FindBy(css = "div.primary a.action.create.primary")
    WebElement CreateAccountLink;
    @FindBy(linkText = "Forgot Your Password?")
    WebElement forgotPasswordLink;
    @FindBy(css = "div.messages div.message-error")
    WebElement Message;
    @FindBy(id = "pass-error")
    WebElement MessagePassError;
    @FindBy(id = "email-error")
    WebElement MessageEmailError;
    // Locator for the success message on the login page
    @FindBy(css = "div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    WebElement successMessage;
    private String email;
    private String password;

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
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RegisterPage register() {
        CreateAccountLink.click();
        return new RegisterPage(driver);
    }

    // Method to get the success message text
    public String getSuccessMessageText() {
        return successMessage.getText();
    }

    public void login() {
        EmailField.sendKeys(email);
        PasswordField.sendKeys(password);
        LoginButton.click();
    }

    public ForgotPasswordPage forgotPassword() {
        forgotPasswordLink.click();
        return new ForgotPasswordPage(driver);
    }


    public String getMessage() {
        return Message.getText();
    }

    public String getMessagePassError() {
        return MessagePassError.getText();
    }

    public String getMessageEmailError() {
        waitForVisibility(MessageEmailError);
        return MessageEmailError.getText();
    }


}
