package com.magento.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class Footer extends BasePage {
    // Locate the footer links
    @FindBy(css = "div.footer.content ul.footer.links li.nav.item a")
    private List<WebElement> footerLinks;
    // Locate the static block links within the footer
    @FindBy(css = "div.footer.content div.links ul li a")
    private List<WebElement> staticBlockLinks;

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
    public Footer(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicks a footer link by its text.
     * @param linkText the text of the link to be clicked
     */
    public void clickFooterLink(String linkText) {
        for (WebElement link : footerLinks) {
            if (link.getText().trim().equalsIgnoreCase(linkText)) {
                link.click();
                break;
            }
        }
    }

    /**
     * Clicks a static block link by its text.
     * @param linkText the text of the link to be clicked
     */
    public void clickStaticBlockLink(String linkText) {
        for (WebElement link : staticBlockLinks) {
            if (link.getText().trim().equalsIgnoreCase(linkText)) {
                link.click();
                break;
            }
        }
    }

    /**
     * Gets the list of all footer links text.
     * @return list of footer links text
     */
    public List<String> getFooterLinksText() {
        return footerLinks.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    /**
     * Gets the list of all static block links text.
     * @return list of static block links text
     */
    public List<String> getStaticBlockLinksText() {
        return staticBlockLinks.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    /**
     * Verifies if all footer links are displayed.
     * @return true if all links are displayed, false otherwise
     */
    public boolean areFooterLinksDisplayed() {
        for (WebElement link : footerLinks) {
            if (!link.isDisplayed()) {
                return false;
            }
        }
        return true;
    }


    /**
     * Gets the list of all footer links.
     * @return list of footer links WebElements
     */
    public List<WebElement> getFooterLinks() {
        return footerLinks;
    }
}
