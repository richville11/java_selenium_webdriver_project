package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {

    private WebDriver driver;
    private By horizontalSlider = By.xpath("//input");
    private By rangeValueResults = By.id("range");

    public HorizontalSliderPage(WebDriver driver){this.driver = driver;}

    public void selectSliderValue(String slidervalue){
        driver.findElement(horizontalSlider).sendKeys(slidervalue);
    }

    public String getRangeStringResults(){
        return driver.findElement(rangeValueResults).getText();
    }
    //End of Class
}
