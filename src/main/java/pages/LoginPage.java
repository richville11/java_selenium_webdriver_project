package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By loginId = By.id("username");
    private By passwordId = By.xpath("//input[contains(@id,'password')]");
    private By loginButtonId  = By.xpath("//button[contains(@class,'radius')]");

    //constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterTextLoginId(String loginIdText){
        driver.findElement(loginId).sendKeys(loginIdText);
    }

    public void enterTextPassword(String passwordText){
        driver.findElement(passwordId).sendKeys(passwordText);
    }

    //Page Chaining pattern in Selenium
    public SecureAreaPage clickLoginButton(){
        driver.findElement(loginButtonId).click();
        return new SecureAreaPage(driver);
    }




    //End Class
}
