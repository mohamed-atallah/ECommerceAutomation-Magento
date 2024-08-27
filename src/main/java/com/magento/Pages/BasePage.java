package com.magento.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * BasePage is a base class for all page objects. It contains common functionalities
 * that can be used across different page objects in the test framework.
 */
public class BasePage {
    // Protected WebDriver instance, accessible to subclasses
    protected WebDriver driver;
    // Protected Actions instance to be used in subclasses
    protected Actions actions;
    // Protected WebDriver instance to be used in subclasses
    protected WebDriver.Navigation navigate;
    // Private WebDriverWait instance to manage waits
    protected WebDriverWait wait;
    JavascriptExecutor js;

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
    public BasePage(WebDriver driver) {
        this.driver = driver;
        // Initialize WebDriver.Navigation for handling browser navigation actions
        this.navigate = driver.navigate();
        // Initialize WebDriverWait with a 10-second timeout
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Initialize Actions for handling user interactions like clicks and keyboard inputs
        this.actions = new Actions(driver);
        // Initialize WebElements on this page using PageFactory
        PageFactory.initElements(driver, this);
        // Re-initialize Actions (if needed)
        this.actions = new Actions(driver);
        // Re-initialize WebElements using PageFactory (if needed)
        PageFactory.initElements(driver, this);
        // Initialize JavascriptExecutor for executing JavaScript code
        js = (JavascriptExecutor) driver;
    }

    /**
     * Waits for the visibility of the specified WebElement.
     *
     * @param element WebElement to wait for
     */
    protected void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for the specified WebElement to be clickable.
     *
     * @param element WebElement to wait for
     */
    protected void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits for the visibility of the specified WebElement and then clicks it.
     *
     * @param element WebElement to click
     */
    protected void click(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    /**
     * Waits for the visibility of the specified WebElement, clears its content, and types the specified text.
     * @param element WebElement to type text into
     * @param text    Text to type
     */
    protected void clearAndWrite(WebElement element, String text) {
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Waits for the visibility of the specified WebElement and returns its text content.
     * @param element WebElement to get text from
     * @return Text content of the WebElement
     */
    protected String getText(WebElement element) {
        waitForVisibility(element);
        return element.getText();
    }

    /**
     * Hovers over the specified WebElement.
     *
     * @param element WebElement to hover over
     */
    protected void hoverOverElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    /**
     * Use Actions class to perform right-click (context-click) and open in a new tab
     */
    protected void openAtNewTab(WebElement element) {
        hoverOverElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        actions.keyDown(Keys.CONTROL).click().perform();

    }
    // Method to scroll down by a specified number of pixels
    public void scrollByPixels(int x, int y) {
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    // Method to scroll to the bottom of the page
    public void scrollToBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    // Method to scroll to the top of the page
    public void scrollToTop() {
        js.executeScript("window.scrollTo(0, 0);");
    }

    // Method to scroll to an element on the page
    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
