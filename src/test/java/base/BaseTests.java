package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Homepage;

import java.util.HashMap;
import java.util.Map;

public class BaseTests {

    private static WebDriver driver;

    //that's why this is set as protected so that test classes that will
    // inherit from this will have access to this homepage class
    protected static Homepage homepage;
    private static String baseUrl = "https://the-internet.herokuapp.com/";

    @BeforeAll
    public static void setupChromeDriverAndBaseUrl() throws InterruptedException {
        /**
         *     "path to the chromedriver"
         *     "System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");"
         * No need for the code above because selenium 4.41 (and above) detects the local Chrome version & fetches the matching driver automatically.
         * No need to download chromedriver.exe as well.
         */

        // 1. Initialize ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito"); //bypasses all password manager logic (because of the chrome password pop-up issue)

        //enough to dectect local chrome version and fetches the matching driver.
        //Initialize the driver with the options
        driver = new ChromeDriver(options);
        driver.get(baseUrl);
        driver.manage().window().maximize();

        homepage = new Homepage(driver);
    }

    @AfterAll
    public static void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
