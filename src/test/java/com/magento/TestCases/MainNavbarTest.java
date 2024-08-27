package com.magento.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainNavbarTest extends BaseTest {


    @Test
    public void testWhatsNewNavigation() {
        mainNavbar.clickWhatsNew();
        Assert.assertTrue(driver.getCurrentUrl().contains("what-is-new"),
                "Navigation to 'What's New' page failed.");
    }

    @Test
    public void testWomenNavigation() {
        mainNavbar.clickWomen();
        Assert.assertTrue(driver.getCurrentUrl().contains("women"),
                "Navigation to 'Women' page failed.");
    }

    @Test
    public void testMenNavigation() {
        mainNavbar.clickMen();
        Assert.assertTrue(driver.getCurrentUrl().contains("men"),
                "Navigation to 'Men' page failed.");
    }

    @Test
    public void testGearNavigation() {
        mainNavbar.clickGear();
        Assert.assertTrue(driver.getCurrentUrl().contains("gear"),
                "Navigation to 'Gear' page failed.");
    }

    @Test
    public void testTrainingNavigation() {
        mainNavbar.clickTraining();
        Assert.assertTrue(driver.getCurrentUrl().contains("training"),
                "Navigation to 'Training' page failed.");
    }

    @Test
    public void testSaleNavigation() {
        mainNavbar.clickSale();
        Assert.assertTrue(driver.getCurrentUrl().contains("sale"),
                "Navigation to 'Sale' page failed.");
    }

    // Submenu Tests - Women
    @Test
    public void testWomenTopsNavigation() {
        mainNavbar.clickWomenTops();
        Assert.assertTrue(driver.getCurrentUrl().contains("tops-women"),
                "Navigation to 'Women's Tops' page failed.");
    }

    @Test
    public void testWomenJacketsNavigation() {
        mainNavbar.clickWomenJackets();
        Assert.assertTrue(driver.getCurrentUrl().contains("jackets-women"),
                "Navigation to 'Women's Jackets' page failed.");
    }

    @Test
    public void testWomenHoodiesSweatshirtsNavigation() {
        mainNavbar.clickWomenHoodiesSweatshirts();
        Assert.assertTrue(driver.getCurrentUrl().contains("hoodies-and-sweatshirts-women"),
                "Navigation to 'Women's Hoodies & Sweatshirts' page failed.");
    }

    @Test
    public void testWomenTeesNavigation() {
        mainNavbar.clickWomenTees();
        Assert.assertTrue(driver.getCurrentUrl().contains("tees-women"),
                "Navigation to 'Women's Tees' page failed.");
    }

    @Test
    public void testWomenTanksNavigation() {
        mainNavbar.clickWomenTanks();
        Assert.assertTrue(driver.getCurrentUrl().contains("tanks-women"),
                "Navigation to 'Women's Tanks' page failed.");
    }

    @Test
    public void testWomenBottomsNavigation() {
        mainNavbar.clickWomenBottoms();
        Assert.assertTrue(driver.getCurrentUrl().contains("bottoms-women"),
                "Navigation to 'Women's Bottoms' page failed.");
    }

    @Test
    public void testWomenPantsNavigation() {
        mainNavbar.clickWomenPants();
        Assert.assertTrue(driver.getCurrentUrl().contains("pants-women"),
                "Navigation to 'Women's Pants' page failed.");
    }

    @Test
    public void testWomenShortsNavigation() {
        mainNavbar.clickWomenShorts();
        Assert.assertTrue(driver.getCurrentUrl().contains("shorts-women"),
                "Navigation to 'Women's Shorts' page failed.");
    }

    // Submenu Tests - Men
    @Test
    public void testMenTopsNavigation() {
        mainNavbar.clickMenTops();
        Assert.assertTrue(driver.getCurrentUrl().contains("tops-men"),
                "Navigation to 'Men's Tops' page failed.");
    }

    @Test
    public void testMenJacketsNavigation() {
        mainNavbar.clickMenJackets();
        Assert.assertTrue(driver.getCurrentUrl().contains("jackets-men"),
                "Navigation to 'Men's Jackets' page failed.");
    }

    @Test
    public void testMenHoodiesSweatshirtsNavigation() {
        mainNavbar.clickMenHoodiesSweatshirts();
        Assert.assertTrue(driver.getCurrentUrl().contains("hoodies-and-sweatshirts-men"),
                "Navigation to 'Men's Hoodies & Sweatshirts' page failed.");
    }

    @Test
    public void testMenTeesNavigation() {
        mainNavbar.clickMenTees();
        Assert.assertTrue(driver.getCurrentUrl().contains("tees-men"),
                "Navigation to 'Men's Tees' page failed.");
    }

    @Test
    public void testMenTanksNavigation() {
        mainNavbar.clickMenTanks();
        Assert.assertTrue(driver.getCurrentUrl().contains("tanks-men"),
                "Navigation to 'Men's Tanks' page failed.");
    }

    @Test
    public void testMenBottomsNavigation() {
        mainNavbar.clickMenBottoms();
        Assert.assertTrue(driver.getCurrentUrl().contains("bottoms-men"),
                "Navigation to 'Men's Bottoms' page failed.");
    }

    @Test
    public void testMenPantsNavigation() {
        mainNavbar.clickMenPants();
        Assert.assertTrue(driver.getCurrentUrl().contains("pants-men"),
                "Navigation to 'Men's Pants' page failed.");
    }

    @Test
    public void testMenShortsNavigation() {
        mainNavbar.clickMenShorts();
        Assert.assertTrue(driver.getCurrentUrl().contains("shorts-men"),
                "Navigation to 'Men's Shorts' page failed.");
    }

    // Submenu Tests - Gear
    @Test
    public void testGearBagsNavigation() {
        mainNavbar.clickGearBags();
        Assert.assertTrue(driver.getCurrentUrl().contains("bags"),
                "Navigation to 'Gear Bags' page failed.");
    }

    @Test
    public void testGearFitnessEquipmentNavigation() {
        mainNavbar.clickGearFitnessEquipment();
        Assert.assertTrue(driver.getCurrentUrl().contains("fitness-equipment"),
                "Navigation to 'Fitness Equipment' page failed.");
    }

    @Test
    public void testGearWatchesNavigation() {
        mainNavbar.clickGearWatches();
        Assert.assertTrue(driver.getCurrentUrl().contains("watches"),
                "Navigation to 'Watches' page failed.");
    }

    // Submenu Tests - Training
    @Test
    public void testTrainingVideoDownloadNavigation() {
        mainNavbar.clickTrainingVideoDownload();
        Assert.assertTrue(driver.getCurrentUrl().contains("training-video"),
                "Navigation to 'Training Video Download' page failed.");
    }
}
