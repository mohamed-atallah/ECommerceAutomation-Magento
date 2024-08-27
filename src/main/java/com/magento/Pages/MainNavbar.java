package com.magento.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainNavbar extends BasePage {
    //Locators for Main Navbar Items
    @FindBy(id = "ui-id-3")
    WebElement whatsNew;
    @FindBy(id = "ui-id-4")
    WebElement women;
    @FindBy(id = "ui-id-5")
    WebElement men;
    @FindBy(id = "ui-id-6")
    WebElement gear;
    @FindBy(id = "ui-id-7")
    WebElement training;
    @FindBy(id = "ui-id-8")
    WebElement sale;
    // Locators for Women Submenu
    @FindBy(id = "ui-id-9")
    WebElement womenTops;
    @FindBy(id = "ui-id-10")
    WebElement womenBottoms;
    // Locators for Women -> Tops Submenu
    @FindBy(id = "ui-id-11")
    WebElement womenJackets;
    @FindBy(id = "ui-id-12")
    WebElement womenHoodiesSweatshirts;
    @FindBy(id = "ui-id-13")
    WebElement womenTees;
    @FindBy(id = "ui-id-14")
    WebElement womenTanks;
    // Locators for Women -> Bottoms Submenu
    @FindBy(id = "ui-id-15")
    WebElement womenPants;
    @FindBy(id = "ui-id-16")
    WebElement womenShorts;
    // Locators for Men Submenu
    @FindBy(id = "ui-id-17")
    WebElement menTops;
    @FindBy(id = "ui-id-18")
    WebElement menBottoms;
    // Locators for Men -> Tops Submenu
    @FindBy(id = "ui-id-19")
    WebElement menJackets;
    @FindBy(id = "ui-id-20")
    WebElement menHoodiesSweatshirts;
    @FindBy(id = "ui-id-21")
    WebElement menTees;
    @FindBy(id = "ui-id-22")
    WebElement menTanks;
    // Locators for Men -> Bottoms Submenu
    @FindBy(id = "ui-id-23")
    WebElement menPants;
    @FindBy(id = "ui-id-24")
    WebElement menShorts;
    // Locators for Gear Submenu
    @FindBy(id = "ui-id-25")
    WebElement gearBags;
    @FindBy(id = "ui-id-26")
    WebElement gearFitnessEquipment;
    @FindBy(id = "ui-id-27")
    WebElement gearWatches;
    // Locators for Training Submenu
    @FindBy(id = "ui-id-28")
    WebElement trainingVideoDownload;

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
    public MainNavbar(WebDriver driver) {
        super(driver);
    }

    public void clickWhatsNew() {
        whatsNew.click();
    }

    // Methods for Hovering and Clicking Submenus
    public void hoverWomen() {
        actions.moveToElement(women).perform();
    }

    public void hoverWomenTops() {
        actions.moveToElement(womenTops).perform();
    }

    public void clickWomenTops() {
        hoverWomen();
        womenTops.click();
    }

    public void clickWomenJackets() {
        hoverWomen();
        hoverWomenTops();
        womenJackets.click();
    }

    public void clickWomenHoodiesSweatshirts() {
        hoverWomen();
        hoverWomenTops();
        womenHoodiesSweatshirts.click();
    }

    public void clickWomenTees() {
        hoverWomen();
        hoverWomenTops();
        womenTees.click();
    }

    public void clickWomenTanks() {
        hoverWomen();
        hoverWomenTops();
        womenTanks.click();
    }

    public void clickWomenBottoms() {
        hoverWomen();
        womenBottoms.click();
    }

    public void hoverWomenBottoms() {
        actions.moveToElement(womenBottoms).perform();

    }

    public void clickWomenPants() {
        hoverWomen();
        hoverWomenBottoms();
        womenPants.click();
    }

    public void clickWomenShorts() {
        hoverWomen();
        hoverWomenBottoms();
        womenShorts.click();
    }

    public void hoverMenBottoms() {
        actions.moveToElement(menBottoms).perform();
    }

    public void hoverMenTops() {
        actions.moveToElement(menTops).perform();
    }

    public void hoverMen() {
        actions.moveToElement(men).perform();
    }

    public void clickMenTops() {
        hoverMen();
        menTops.click();
    }

    public void clickMenJackets() {
        hoverMen();
        hoverMenTops();
        menJackets.click();
    }

    public void clickMenHoodiesSweatshirts() {
        hoverMen();
        hoverMenTops();
        menHoodiesSweatshirts.click();
    }

    public void clickMenTees() {
        hoverMen();
        hoverMenTops();
        menTees.click();
    }

    public void clickMenTanks() {
        hoverMen();
        hoverMenTops();
        menTanks.click();
    }

    public void clickMenBottoms() {
        hoverMen();
        menBottoms.click();
    }

    public void clickMenPants() {
        hoverMen();
        hoverMenBottoms();
        menPants.click();
    }

    public void clickMenShorts() {
        hoverMen();
        hoverMenBottoms();
        menShorts.click();
    }

    public void hoverGear() {
        actions.moveToElement(gear).perform();
    }

    public void clickGearBags() {
        hoverGear();
        gearBags.click();
    }

    public void clickGear() {
        hoverGear();
        gear.click();
    }

    public void clickGearFitnessEquipment() {
        hoverGear();
        gearFitnessEquipment.click();
    }

    public void clickGearWatches() {
        hoverGear();
        gearWatches.click();
    }

    public void hoverTraining() {
        actions.moveToElement(training).perform();
    }

    public void clickTrainingVideoDownload() {
        hoverTraining();
        trainingVideoDownload.click();
    }

    public void clickTraining() {
        hoverTraining();
        training.click();
    }

    public void clickSale() {
        hoverWomen();
        sale.click();
    }

    public void clickWomen() {
        hoverWomen();
        women.click();
    }

    public void clickMen() {
        hoverMen();
        men.click();
    }
}
