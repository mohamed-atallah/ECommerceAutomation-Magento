package com.magento.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TopsMenTest extends BaseTest {


    @Test
    public void testMenTopsNavigation() {
        mainNavbar.clickMenTops();
        Assert.assertTrue(driver.getCurrentUrl().contains("tops-men"),
                "Navigation to 'Men's Tops' page failed.");
    }

    @Test
    public void testMenTopsNavigationToSecondPage() {
        productHelper.closeAD();
        productHelper.selectPageByHref(2);
        Assert.assertTrue(driver.getCurrentUrl().contains("tops-men.html?p=2"),
                "Navigation to 'Men's Tops' page failed on second page.");
    }

    @Test
    public void testAddedProductsFromSamePage() {
        mainNavbar.clickMenTops();
        productHelper.addToCartWithAttributes(0, "blue", "M");
        header.waitForCartCounterToIncrease(0);
        productHelper.addToCartWithAttributes(4, "green", "l");
        header.waitForCartCounterToIncrease(1);
        productHelper.addToCartWithAttributes(9, "red", "xs");
        header.waitForCartCounterToIncrease(2);
        String itemCount = productHelper.cartItemCount.getText();
        System.out.println("Item Count is : " + itemCount);
        Assert.assertEquals(itemCount, "3", "Item count in cart is incorrect!");
    }

    @Test
    public void testSortingByProductName() {
        mainNavbar.clickMenTops();
        // Step 2: Select "Product Name" from the sorting dropdown
        productHelper.selectSorterByVisibleText("Product Name");
        // Step 3: Scroll to the bottom of the page (if needed)
        productHelper.scrollToBottom();
        // Step 4: Verify that "Product Name" is selected in the dropdown
        boolean isProductNameSelected = productHelper.isOptionSelected("Product Name");
        // Step 5: Assert that the "Product Name" option is indeed selected
        Assert.assertTrue(isProductNameSelected, "The 'Product Name' option should be selected.");
    }

    @Test(priority = 10)
    public void testNotAddedProductToWishlistWithoutSignIn() {
        productHelper.closeAD();
        productHelper.addToWishlist(1);
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "incorrect navigation");
        Assert.assertEquals(loginPage.getMessage(), "You must login or register to add items to your wishlist.", "incorrect message ");

    }


}
