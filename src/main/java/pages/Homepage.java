package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {

    private WebDriver driver;
    private By formAuthenticationLink = By.linkText("Form Authentication");

    //constructor
    public Homepage(WebDriver driver){
        this.driver = driver;
    }


    private void clickLink(String linktextValue){
        driver.findElement(By.linkText(linktextValue)).click();
    }

    public LoginPage clickFormAuthenticationLink(){
//        driver.findElement(formAuthenticationLink).click();
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropdownPage clickDropDownLink(){
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }


    public HoversPage clickhoversPage(){
        clickLink("Hovers");
        return new HoversPage(driver);
    }


    public KeyPressesPage clickKeyPressesPage(){
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }

    public HorizontalSliderPage clickHorizontalSliderPage(){
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }

    //End Class
}
