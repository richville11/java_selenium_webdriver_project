package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {

    private WebDriver driver;
//    private By secureAreaPageTitlePage = By.id("flash");
    private By secureAreaPageTitlePage = By.xpath("//div[contains(@class,'flash success')]");

    //contructor
    public SecureAreaPage(WebDriver driver){
        this.driver = driver;
    }

    public String getSecureAreaPageTitleText(){
        return driver.findElement(secureAreaPageTitlePage).getText();
    }

}
