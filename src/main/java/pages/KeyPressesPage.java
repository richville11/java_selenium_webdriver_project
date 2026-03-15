package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage {

    private WebDriver driver;
    private By keyPressTextBox = By.id("target");
    private By resultText = By.id("result");

    public KeyPressesPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterTextKeyPressField(String text){
        driver.findElement(keyPressTextBox).sendKeys(text);
    }

    public String getResultText(){
        return driver.findElement(resultText).getText();
    }

    public void enterPi(){
        driver.findElement(keyPressTextBox).sendKeys(Keys.ALT, "p");
    }

}
