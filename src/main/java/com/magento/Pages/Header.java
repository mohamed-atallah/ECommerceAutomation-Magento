package com.magento.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class Header extends BasePage {
    @FindBy(className = "counter-number")
    public WebElement counterElement;
    @FindBy(id = "search")
    WebElement searchInput;
    @FindBy(partialLinkText = "Sign In")
    WebElement signInLink;
    @FindBy(linkText = "Create an Account")
    WebElement createAccountLink;
    @FindBy(css = "a.logo")
    WebElement logoLink;
    @FindBy(id = "store.menu")
    WebElement navMenu;

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
    public Header(WebDriver driver) {
        super(driver);

    }

    public void setSearchInput(String searchKeyword) {
        waitForVisibility(searchInput);
        clearAndWrite(searchInput, searchKeyword);
    }

    public boolean checkSearchDisplayed() {
        waitForVisibility(searchInput);
        return searchInput.isDisplayed();
    }

    public boolean isNavMenuDisplayed() {
        waitForVisibility(navMenu);
        return navMenu.isDisplayed();
    }

    public void waitForCartCounterToIncrease(int initialCount) {
        // Wait until the counter increases from the initial count
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                String counterText = counterElement.getText();
                try {
                    int currentCount = Integer.parseInt(counterText);
                    return currentCount > initialCount;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        });
    }

    public LoginPage getLogingPage() {
        click(signInLink);
        return new LoginPage(driver);
    }

    public RegisterPage getRegisterPage() {
        waitForVisibility(createAccountLink);
        click(createAccountLink);
        return new RegisterPage(driver);
    }

    public LandingPage getLandingPage() {
        click(logoLink);
        return new LandingPage(driver);
    }

}
