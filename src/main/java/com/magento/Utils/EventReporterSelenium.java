package com.magento.Utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class EventReporterSelenium implements WebDriverListener {


    @Override
    public void beforeClick(WebElement element) {
        // Example: Printing the text
        String text = element.getText();
        System.out.println("Before clicking on element: " + text);
    }
 /*   @Override
    public void afterClick(WebElement element) {
        try {
            if (element.isDisplayed()) {
                String text = element.getText();
                System.out.println("After clicking on element: " + text);
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is no longer attached to the DOM.");
        } catch (Exception e) {
            System.out.println("An error occurred after clicking: " + e.getMessage());
        }
    }*/

    @Override
    public void afterGet(WebDriver driver, String url) {
        System.out.println("Navigated to: " + url);
    }
}
