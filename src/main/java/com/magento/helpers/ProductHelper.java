package com.magento.helpers;

import com.magento.Pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductHelper extends BasePage {
    @FindBy(xpath = "//span[@class='counter-number']")
    public WebElement cartItemCount;
    // Locator for the select dropdown
    @FindBy(id = "sorter")
    WebElement sorterDropdown;
    @FindBy(css = "ol.product-items li.product-item")
    private List<WebElement> productItems;
    @FindBy(className = "ea-stickybox-hide")
    private WebElement closeADButton;
    // Locator for page number links
    @FindBy(css = "ul.items.pages-items li.item a.page")
    private List<WebElement> pageLinks;
    @FindBy(css = "li.pages-item-previous a.previous")
    private WebElement previousPageButton;
    @FindBy(css = "li.pages-item-next a.next")
    private WebElement nextPageButton;
    @FindBy(css = "li.item.current strong.page")
    private WebElement currentPage;

    // Locate the current page number element
    @FindBy(css = "li.item.current strong.page span:nth-of-type(2)")
    private WebElement currentPageElement;
    @FindBy(css = "div.pages")
    private WebElement paginationContainer;
    @FindBy(css = "li.product-item a.product-item-link")
    private List<WebElement> productLinks;

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
    public ProductHelper(WebDriver driver) {
        super(driver);
    }

    // Method to get the list of product items
    public List<WebElement> getProductItems() {
        return productItems;
    }

    // Method to add a product to the wishlist by index
    public void addToWishlist(int productIndex) {
        WebElement product = productItems.get(productIndex);
        hoverOverElement(product);
        product.findElement(By.cssSelector("a.action.towishlist[role='button']")).click();
    }

    public void addToCartWithAttributes(int productIndex, String color, String size) {
        // Wait for product to load
        wait.until(ExpectedConditions.visibilityOfAllElements(productItems));
        WebElement product = productItems.get(productIndex);
        // Check if size options exist
        List<WebElement> sizeOptionsList = product.findElements(By.cssSelector("div.swatch-attribute.size .swatch-option"));
        if (!sizeOptionsList.isEmpty()) {
            selectOption(sizeOptionsList, size);
        }
        // Check if color options exist
        List<WebElement> colorOptionsList = product.findElements(By.cssSelector("div.swatch-attribute.color .swatch-option"));
        if (!colorOptionsList.isEmpty()) {
            selectOption(colorOptionsList, color);
        }
        // Add to cart
        product.findElement(By.cssSelector("button.action.tocart.primary")).click();
    }

    private void selectOption(List<WebElement> optionsList, String desiredOption) {
        for (WebElement option : optionsList) {
            String optionLabel = option.getAttribute("aria-label");
            if (optionLabel.equalsIgnoreCase(desiredOption)) {
                option.click();
                break;
            }
        }
    }

    public void addToCartWithoutAttributes(int productIndex) {
        WebElement product = productItems.get(productIndex);
        hoverOverElement(product);
        product.findElement(By.cssSelector("button.action.tocart.primary")).click();
    }

    public void closeAD() {
        try {
            // Check if the element is displayed
            if (closeADButton.isDisplayed()) {
                // Click the close button if it is displayed
                closeADButton.click();
                System.out.println("Ad closed successfully.");
            }
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            // Handle exceptions in case the element is not found or not interactable
            System.out.println("Ad is not present or not interactable.");
        }
    }


    // Method to select an option by visible text
    public void selectSorterByVisibleText(String visibleText) {
        Select select = new Select(sorterDropdown);
        select.selectByVisibleText(visibleText);
    }
    // Method to check if pagination is displayed

    // Method to select an option by value
    public void selectSorterByValue(String value) {
        Select select = new Select(sorterDropdown);
        select.selectByValue(value);
    }

    // Method to select an option by index
    public void selectSorterByIndex(int index) {
        Select select = new Select(sorterDropdown);
        select.selectByIndex(index);
    }

    // Method to verify if the "Next" button is displayed and clickable
    public boolean isNextPageDisplayed() {
        return nextPageButton.isDisplayed();
    }

    // Method to click "Next" page link
    public void clickNextPage() {
        if (isNextPageDisplayed()) {
            nextPageButton.click();
        }
    }

    // Method to verify if the "Previous" button is displayed and clickable
    public boolean isPreviousLinkDisplayed() {
        return previousPageButton.isDisplayed();
    }

    // Method to click "Previous" page link
    public void clickPreviousLink() {
        if (isPreviousLinkDisplayed()) {
            previousPageButton.click();
        }
    }

    // Method to get the current page number
    public String getCurrentPageNumber() {
        return currentPage.getText();
    }

    // Method to select page by URL parameter p=n
    public void selectPageByHref(int pageNumber) {
        boolean pageFound = false;
        // Construct the expected href fragment for the desired page
        String expectedHrefFragment = "?p=" + pageNumber;
        // Loop through all page links to find the one with the correct href
        for (WebElement pageLink : pageLinks) {
            String href = pageLink.getAttribute("href");
            if (href.contains(expectedHrefFragment)) {
                pageFound = true;
                try {
                    pageLink.click();
                    System.out.println("Navigating to page: " + pageNumber);
                    break;
                } catch (Exception e) {
                    System.out.println("Failed to click the page link: " + e.getMessage());
                }
            }
        }

        // If no page link is found with the expected href
        if (!pageFound) {
            System.out.println("Page number " + pageNumber + " not found.");
        }
    }

    // Method to wait for the page to load
    public void waitForPageLoad() {
        // Implement a wait mechanism to ensure the page is loaded before performing further actions
        waitForVisibility(paginationContainer);
    }

    public boolean isOptionSelected(String optionValue) {
        // Create a Select object for interacting with the dropdown
        Select select = new Select(sorterDropdown);

        // Get the currently selected option
        WebElement selectedOption = select.getFirstSelectedOption();

        // Check if the selected option's value or visible text matches the provided option value
        return selectedOption.getAttribute("value").equals(optionValue) || selectedOption.getText().trim().equals(optionValue);
    }

}
