package com.magento.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LandingPage extends BasePage {

    @FindBy(className = "main")
    public WebElement mainContentArea;
    // Find the product link within each product item
    @FindBy(css = "li.product-item a.product-item-link")
    private List<WebElement> productLinks;
    // Find the product price within each product item
    @FindBy(css = "li.product-item span.price-wrapper")
    private List<WebElement> productPrices;
    // Find the "Add to Cart" button within each product item
    @FindBy(css = "li.product-item button.action.tocart.primary")
    private List<WebElement> addToCartButtons;
    // Find the "Add to Wishlist" button within each product item
    @FindBy(css = "li.product-item a.action.towishlist")
    private List<WebElement> addToWishlistButtons;
    // Find the "Add to Compare" button within each product item
    @FindBy(css = "li.product-item a.action.tocompare")
    private List<WebElement> addToCompareButtons;
    @FindBy(css = "ol.product-items li.product-item")
    private List<WebElement> productItems;
    @FindBy(css = "div.swatch-attribute.size")
    private List<WebElement> sizeOptions;
    @FindBy(css = "div.swatch-attribute.color")
    private List<WebElement> colorOptions;
    @FindBy(className = "ea-stickybox-hide")
    private WebElement closeADButton;
    // Locators for promo blocks
    @FindBy(css = ".block-promo.home-pants")
    private WebElement shopPantsPromo;

    @FindBy(css = ".block-promo.home-t-shirts")
    private WebElement shopTeesPromo;

    @FindBy(css = ".block-promo.home-erin")
    private WebElement shopErinPromo;

    @FindBy(css = ".block-promo.home-performance")
    private WebElement shopPerformancePromo;

    @FindBy(css = ".block-promo.home-eco")
    private WebElement shopEcoPromo;


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
    public LandingPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Returns the text content of the main content area.
     */
    public String getMainContentArea() {
        waitForVisibility(mainContentArea);
        return mainContentArea.getText();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public Header getHeader() {
        return new Header(driver);
    }

    public Footer getFooter() {
        return new Footer(driver);
    }

    // Methods to perform actions on promo blocks
    public void clickShopPantsPromo() {
        shopPantsPromo.click();
    }

    public void clickShopTeesPromo() {
        shopTeesPromo.click();
    }

    public void clickShopErinPromo() {
        shopErinPromo.click();
    }

    public void clickShopPerformancePromo() {
        shopPerformancePromo.click();
    }

    public void clickShopEcoPromo() {
        shopEcoPromo.click();
    }

    // Methods to verify if the promo blocks are displayed
    public boolean isShopPantsPromoDisplayed() {
        return shopPantsPromo.isDisplayed();
    }

    public boolean isShopTeesPromoDisplayed() {
        return shopTeesPromo.isDisplayed();
    }

    public boolean isShopErinPromoDisplayed() {
        return shopErinPromo.isDisplayed();
    }

    public boolean isShopPerformancePromoDisplayed() {
        return shopPerformancePromo.isDisplayed();
    }

    public boolean isShopEcoPromoDisplayed() {
        return shopEcoPromo.isDisplayed();
    }


}


