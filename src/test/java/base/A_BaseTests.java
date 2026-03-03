package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A_BaseTests {

    private WebDriver driver;

    public void setUpWebDriver() throws InterruptedException {

        //make sure to indicate the "webdriver.chrome.driver" properly
        //as this is a key that the selenium will look for.
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");

        //we are creating a new instance for the ChromeDriver
        driver = new ChromeDriver();

        //this will launch the browser
        driver.get("https://the-internet.herokuapp.com");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        driver.manage().window().maximize();

        Thread.sleep(5000);
        System.out.println("Passed: Successfully launch the Browser.");
        driver.quit();

    }

    public static void main(String args[]) throws InterruptedException {
        A_BaseTests test = new A_BaseTests();
        test.setUpWebDriver();
    }
}
