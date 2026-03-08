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






    //End Class
}
