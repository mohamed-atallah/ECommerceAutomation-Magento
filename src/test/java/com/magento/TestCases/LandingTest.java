package com.magento.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

//@Listeners(com.magento.TestCases.MyListenerTestNG.class)
public class LandingTest extends BaseTest {


    @Test
    public void verifyPageTitle() {
        logger.info("Test example started.");
        logger.debug("Test example started.");
        try {
            String actualTitle = driver.getTitle();
            System.out.println("Actual Title: " + actualTitle);
            String expectedTitle = "Home Page";
            Assert.assertEquals(actualTitle, expectedTitle, "Title is not as expected");
        }
        catch (AssertionError e) {
            logger.error("Test failed with message: " + e.getMessage());
            Assert.fail("Test failed");
            logger.debug("Test failed with message: " + e.getMessage());
        }
        logger.info("Test example completed.");

    }

    @Test
    public void verifyMainContentArea() {
        String actualContent = landingPage.getMainContentArea();
        //  System.out.println("Actual Main Content: " + actualContent);
        Assert.assertTrue(actualContent.contains("20% OFF"), "Main content area does not contain expected text");
    }

    @Test
    public void verifySearchVisibility() {
        boolean actualMenuIsVisible = landingPage.getHeader().checkSearchDisplayed();
        System.out.println("Actual Search Bar Visibility: " + actualMenuIsVisible);
        Assert.assertTrue(actualMenuIsVisible, "Header menu is not visible");
    }

    @Test
    public void verifyFooterLinksDisplayed() {
        // Verify that all footer links are displayed
        boolean allLinksDisplayed = landingPage.getFooter().areFooterLinksDisplayed();
        Assert.assertTrue(allLinksDisplayed, "Not all footer links are displayed!");

        // Alternatively, you can print each footer link and check if it’s displayed
        landingPage.getFooter().getFooterLinks().forEach(link -> {
            System.out.println("Verifying visibility of link: " + link.getText());
            Assert.assertTrue(link.isDisplayed(), "Footer link " + link.getText() + " is not displayed!");
        });
    }

    @Test(priority = 5)
    public void verifyFooterLinksOpened() {
        landingPage.getFooter().clickFooterLink("Search Terms");
        Assert.assertEquals(driver.getCurrentUrl(), "https://magento.softwaretestingboard.com/search/term/popular/", "Footer link 'Search Terms' did not open the correct page");
        getWindowManager().goBack();
        landingPage.getFooter().clickFooterLink("Privacy and Cookie Policy");
        Assert.assertTrue(driver.getCurrentUrl().contains("privacy-policy"), "Footer link 'Privacy and Cookie Policy' did not open the correct page");
        getWindowManager().goBack();
        landingPage.getFooter().clickFooterLink("Advanced Search");
        Assert.assertTrue(driver.getCurrentUrl().contains("advanced"), "Footer link 'Advanced Search' did not open the correct page");
        getWindowManager().goBack();
        landingPage.getFooter().clickFooterLink("Orders and Returns");
        Assert.assertTrue(driver.getCurrentUrl().contains("sales"), "Footer link 'Orders and Returns' did not open the correct page");
        getWindowManager().goBack();
    }

    @Test
    public void verifyAddProductToCart() {
        productHelper.closeAD();
        productHelper.addToCartWithAttributes(0, "blue", "s");
        header.waitForCartCounterToIncrease(0);
        productHelper.addToCartWithAttributes(1, "white", "M");
        header.waitForCartCounterToIncrease(1);
        productHelper.addToCartWithAttributes(2, "Gray", "L");
        header.waitForCartCounterToIncrease(2);
        productHelper.addToCartWithAttributes(3, "green", "xs");
        header.waitForCartCounterToIncrease(3);
        productHelper.closeAD();
        productHelper.addToCartWithoutAttributes(4);
        header.waitForCartCounterToIncrease(4);
        productHelper.addToCartWithoutAttributes(5);
        header.waitForCartCounterToIncrease(5);
        System.out.println("Count Of Items in cart : " + header.counterElement.getText());
        Assert.assertEquals(header.counterElement.getText(), "6", "Count Of Items in cart not correct ");
    }

    @Test
    public void testPantsPromoIsDisplayed() {
        Assert.assertTrue(landingPage.isShopPantsPromoDisplayed(), "Pants promo is not displayed.");
    }

    @Test
    public void testTeesPromoIsDisplayed() {
        Assert.assertTrue(landingPage.isShopTeesPromoDisplayed(), "Tees promo is not displayed.");
    }

    @Test
    public void testErinPromoIsDisplayed() {
        Assert.assertTrue(landingPage.isShopErinPromoDisplayed(), "Erin promo is not displayed.");
    }

    @Test
    public void testPerformancePromoIsDisplayed() {
        Assert.assertTrue(landingPage.isShopPerformancePromoDisplayed(), "Performance promo is not displayed.");
    }

    @Test
    public void testEcoPromoIsDisplayed() {
        Assert.assertTrue(landingPage.isShopEcoPromoDisplayed(), "Eco promo is not displayed.");
    }

    @Test
    public void testClickShopPantsPromo() {
        landingPage.clickShopPantsPromo();  // Clicks the "Shop Pants" promo block
        Assert.assertTrue(driver.getCurrentUrl().contains("promotions/pants-all"), "d");
        getWindowManager().goBack();
    }

    @Test
    public void testClickShopTeesPromo() {
        landingPage.clickShopTeesPromo();  // Clicks the "Shop Tees" promo block
        Assert.assertTrue(driver.getCurrentUrl().contains("promotions/tees-all"), "invalid url");
        getWindowManager().goBack();
    }

    @Test
    public void testClickShopErinPromo() {
        landingPage.clickShopErinPromo();  // Clicks the "Shop Erin" promo block
        Assert.assertTrue(driver.getCurrentUrl().contains("collections/erin-recommends"), "Invalid redirect URL");
        getWindowManager().goBack();
    }

    @Test
    public void testClickShopPerformancePromo() {
        landingPage.clickShopPerformancePromo();  // Clicks the "Shop Performance" promo block
        Assert.assertTrue(driver.getCurrentUrl().contains("collections/performance-fabrics"), "Invalid redirect URL");
        getWindowManager().goBack();
    }

    @Test
    public void testClickShopEcoPromo() {
        landingPage.clickShopEcoPromo();  // Clicks the "Shop Eco" promo block
        Assert.assertTrue(driver.getCurrentUrl().contains("eco-friendly"), "Incorrect title for shop Eco promo");
        getWindowManager().goBack();
    }


}
