package com.magento.TestCases;

import com.magento.Pages.*;
import com.magento.Utils.ConfigReader;
import com.magento.Utils.EventReporterSelenium;
import com.magento.Utils.WindowManager;
import com.magento.helpers.ProductHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    // Initialize logger
    public Logger logger = LogManager.getLogger(BaseTest.class);
    protected WebDriver driver;
    // Private WebDriverWait instance to manage waits
    protected WebDriverWait wait;
    protected Header header;
    protected LandingPage landingPage;
    protected LoginPage loginPage;
    protected MainNavbar mainNavbar;
    protected RegisterPage registerPage;
    ForgotPasswordPage forgotPasswordPage;
    ProductHelper productHelper;
    String configFilePath = "src/test/resources/config.properties";
    protected ConfigReader configReader = new ConfigReader(configFilePath);
    private String BASE_URL = configReader.getProperty("baseUrl");
    private String SCREENSHOTS_DIR = "C:\\HD\\Selenium Automation Java\\MagentoStore\\Screenshots";

    /**
     * This method is executed before any test class. It sets up the WebDriver instance and configures
     * the Chrome browser with the desired options. The WebDriverManager is used to handle
     * the setup of the ChromeDriver binary automatically.
     */
    @BeforeClass
    @Parameters({"Browser", "Environment"})
    public void setUp(@Optional("chrome") String browser, @Optional("qa") String environment) {
        /**
         *  it means that if TestNG does not find a value for the browser or environment parameter from the external source (e.g., testng.xml or command line),
         *  it will use the provided default values:
         */
        // Log the start of the setup
        logger.info("Starting setup for tests.");
        logger.info("Browser: " + browser);
        logger.info("Environment: " + environment);
        initializeWebDriver(browser);
        // Initialize WebDriverWait with a 10-second timeout
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Create an instance of your WebDriverListener implementation
        EventReporterSelenium eventReporter = new EventReporterSelenium();
        // Wrap the WebDriver instance with the EventFiringDecorator to attach the listener
        WebDriver decoratedDriver = new EventFiringDecorator(eventReporter).decorate(driver);
        System.out.println("Decorated driver initialized");
        // Use the decorated driver for your tests
        this.driver = decoratedDriver;
        System.out.println("Driver assigned to decorated driver");
        // Initialize the LandingPage object
        landingPage = new LandingPage(driver);
        WindowManager wm = new WindowManager(driver);
        header = new Header(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        mainNavbar = new MainNavbar(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        productHelper = new ProductHelper(driver);
        // Navigate to the home page
        driver.get(BASE_URL);
    }

    private void initializeWebDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                // Setup WebDriverManager to manage the ChromeDriver binary
                WebDriverManager.chromedriver().setup();
                // Initialize ChromeOptions to customize ChromeDriver behavior
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized"); // Start the browser maximized
                // Initialize ChromeDriver with the specified options
                driver = new ChromeDriver(options);
                break;
            case "chromeheadless":
                ChromeOptions headlessOptions = new ChromeOptions();

                // Add headless argument
                headlessOptions.addArguments("--headless=new");  // New option for headless mode in Selenium 4
                headlessOptions.addArguments("--disable-gpu");
                headlessOptions.addArguments("--window-size=1920,1080");
                headlessOptions.addArguments("--no-sandbox");
                headlessOptions.addArguments("--disable-dev-shm-usage");
                // Initialize ChromeDriver with headless options
                driver = new ChromeDriver(headlessOptions);
                // Selenium 4 DevTools interaction (Optional)
                DevTools devTools = ((ChromeDriver) driver).getDevTools();
                devTools.createSession();
                // You can also use Page lifecycle events in headless mode
                devTools.send(Page.enable());
                devTools.addListener(Page.loadEventFired(),
                        loadEvent -> System.out.println("Page loaded"));
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    @AfterClass(alwaysRun = false)
    public void tearDownClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}