package com.magento.Utils;

import com.magento.Pages.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowManager extends BasePage {
    public WindowManager(WebDriver driver) {
        super(driver);
    }

    public void goBack() {
        navigate.back();
    }

    public void goForward() {
        navigate.forward();
    }

    public void refresh() {
        navigate.refresh();
    }

    public void goTo(String url) {
        navigate.to(url);
    }

    public void switchToNewTab(String tabTitle) {
        Set<String> windows = driver.getWindowHandles();
        System.out.println("Number of windows: " + windows.size());
        windows.forEach(System.out::println);
        boolean tabFound = false;
        int counter = 0;
        for (String windowHandle : windows) {
            counter++;
            driver.switchTo().window(windowHandle);
            String currentWindowTitle = driver.getTitle();
            System.out.println("Switching to window: " + windowHandle);
            System.out.println("Current window title: " + currentWindowTitle);
            if (currentWindowTitle.equals(tabTitle)) {
                System.out.println("Switched to the tab with title: " + tabTitle);
                tabFound = true;
                break;
            }
        }
        if (!tabFound) {
            System.out.println("No tab with the title: " + tabTitle + " was found.");
        }
    }

}

