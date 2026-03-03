package base;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class B_TestWithElementLocatorsChapter {

    private static WebDriver driver;
    private static String baseUrl = "https://the-internet.herokuapp.com/";
    private static String sauceDemoBaseUrl = "";

//    public static void main(String[] args) throws InterruptedException {
//
//        B_TestWithElementLocatorsChapter test = new B_TestWithElementLocatorsChapter();
//        test.sampleSetupAndTests();
//        test.sampleTestWithFindElementsPlural();
//    }

    @BeforeAll
    public static void setupChromeDriverAndBaseUrl() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    @DisplayName("Test: Use findElement to find single element in DOM")
    @Tag("sanity")
    public void sampleSetupAndTests() throws InterruptedException {

        //findElement will only find the very first element that it finds in the DOM
        WebElement dynamicLinkText = driver.findElement(By.linkText("Dynamic Content"));
        dynamicLinkText.click();
        WebElement dynamicContentTitle = driver.findElement(By.xpath("//h3[contains(text(),'Dynamic Content')]"));
        String pageTitle = dynamicContentTitle.getText();
        System.out.println("Dynamic Content Page Title: " + pageTitle);

        Assertions.assertEquals("Dynamic Content",pageTitle,"Failed: Page title is NOT correct.");

    }

    @Test
    @DisplayName("Test: Use findElement(s) to find multiple elements.")
    @Tag("sanity")
    public void sampleTestWithFindElementsPlural() throws InterruptedException {

        List<WebElement> links = driver.findElements(By.tagName("a"));
        Integer linkSize = links.size();
        System.out.println("Link Size: " + linkSize);

        Assertions.assertEquals(46,linkSize,"Failed: Link Size is NOT correct.");

    }

    @Test
    @DisplayName("Test: Assignment Exercises - Shifting Content")
    void testExercise(){

        WebElement shiftingContentLink = driver.findElement(By.linkText("Shifting Content"));
        shiftingContentLink.click();

        WebElement menuElement = driver.findElement(By.xpath("//a[contains(text(),'Example 1: Menu Element')]"));
        menuElement.click();

        //Test to verify the size of the tab menus
        List<WebElement> tabMenus = driver.findElements(By.xpath("//li"));
        Integer tabMenuSize = tabMenus.size();
        System.out.println(tabMenuSize);

        Assertions.assertEquals(5,tabMenuSize, "Failed: Incorrect Tab Menu Size.");


    }
}
