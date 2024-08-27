package com.magento.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {
    // Page elements
    @FindBy(id = "form-validate")
    private WebElement createAccountForm;

    // First Name input field
    @FindBy(id = "firstname")
    private WebElement firstNameInput;

    // Error message for the first name field
    @FindBy(id = "firstname-error")
    private WebElement firstNameError;

    // Last Name input field
    @FindBy(id = "lastname")
    private WebElement lastNameInput;

    // Error message for the last name field
    @FindBy(id = "lastname-error")
    private WebElement lastNameError;

    // Email input field
    @FindBy(id = "email_address")
    private WebElement emailInput;

    // Error message for the email field
    @FindBy(id = "email_address-error")
    private WebElement emailError;

    // Password input field
    @FindBy(id = "password")
    private WebElement passwordInput;

    // Error message for the password field
    @FindBy(id = "password-error")
    private WebElement passwordError;

    // Password strength meter label
    @FindBy(id = "password-strength-meter-label")
    private WebElement passwordStrengthLabel;

    // Confirm Password input field
    @FindBy(id = "password-confirmation")
    private WebElement confirmPasswordInput;

    // Error message for the confirm password field
    @FindBy(id = "password-confirmation-error")
    private WebElement confirmPasswordError;

    // Submit button (Create an Account)
    @FindBy(css = "button.action.submit.primary")
    private WebElement createAccountButton;

    // Back button
    @FindBy(css = "a.action.back")
    private WebElement backButton;

    // Success message
    @FindBy(css = "div.message-success")
    private WebElement successMessage;
    // Error message
    @FindBy(css = "div.message-error")
    private WebElement errorMessage;

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
    public RegisterPage(WebDriver driver) {
        super(driver);
    }


    // Getters and Setters
    public void setFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOf(lastNameInput));
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void setEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        wait.until(ExpectedConditions.visibilityOf(confirmPasswordInput));
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void clickCreateAccountButton() {
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
        createAccountButton.click();
    }

    public void register(String firstName, String lastName, String email, String password, String confirmPassword) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
        setConfirmPassword(confirmPassword);
        clickCreateAccountButton();
    }

    public String getSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.getText();
    }

    public String getFirstNameError() {
        wait.until(ExpectedConditions.visibilityOf(firstNameError));
        return firstNameError.getText();
    }

    public String getLastNameError() {
        wait.until(ExpectedConditions.visibilityOf(lastNameError));
        return lastNameError.getText();
    }

    public String getEmailError() {
        wait.until(ExpectedConditions.visibilityOf(emailError));
        return emailError.getText();
    }

    public String getPasswordError() {
        wait.until(ExpectedConditions.visibilityOf(passwordError));
        return passwordError.getText();
    }

    public String getConfirmPasswordError() {
        wait.until(ExpectedConditions.visibilityOf(confirmPasswordError));
        return confirmPasswordError.getText();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }
}
