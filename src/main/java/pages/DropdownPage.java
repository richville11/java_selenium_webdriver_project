package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {

    private WebDriver driver;
    private By dropDownBar = By.id("dropdown");
    private By selectedOption = By.xpath("//option[contains(@selected,'selected')]");

    public DropdownPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickDropDownBar(){
        driver.findElement(dropDownBar).click();
    }

    public void selectDropDown(String option){
        Select dropDownElement = new Select(driver.findElement(dropDownBar));
        dropDownElement.selectByVisibleText(option);
    }

    public List<String> getSelectedOption(){
        List<WebElement> selectedElements =
                findDropDownElement().getAllSelectedOptions();
        return  selectedElements.stream().map(e-> e.getText()).collect(Collectors.toList());
    }

    private Select findDropDownElement(){
        return new Select(driver.findElement(dropDownBar));
    }

    public boolean selectedOptionTrue(){
      return driver.findElement(selectedOption).isSelected();
    }


    //End of Class
}
