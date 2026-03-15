package testScenarios;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import pages.*;

public class Test_HeroKuApp extends BaseTests {

    private static String usernameValue = "tomsmith";
    private static String passwordValue = "SuperSecretPassword!";
    private static String actualSecurePageTitleValue;
    private static String expectedSecurePageTitleValue = "You logged into a secure area!\n×";

    @Test
    @DisplayName("TEST 1: Verify Successful Login.")
    public void testSuccessLogin() {

        LoginPage loginPage = homepage.clickFormAuthenticationLink();
        loginPage.enterTextLoginId(usernameValue);
        loginPage.enterTextPassword(passwordValue);

        //Page Chaining model
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        actualSecurePageTitleValue = secureAreaPage.getSecureAreaPageTitleText();

        Assertions.assertEquals(expectedSecurePageTitleValue, actualSecurePageTitleValue,
                "Failed: SecureArea Page Text is NOT found.");

    }

    @Test
    @DisplayName("TEST 2: Verify Dropdown elements.")
    public void testDropDown() {
        DropdownPage dropdownPage = homepage.clickDropDownLink();
        dropdownPage.clickDropDownBar();
        dropdownPage.selectDropDown("Option 1");
        dropdownPage.getSelectedOption();

        boolean isSelectedOption = dropdownPage.selectedOptionTrue();
        Assertions.assertTrue(isSelectedOption, "Failed: Dropdown option is NOT displayed.");

    }


    @Test
    @DisplayName("TEST 3: Verify HOVER elements.")
    public void testHoverUser1() {
        var hoversPage = homepage.clickhoversPage();
        var caption = hoversPage.hoverOverFigure(1);
        Assertions.assertTrue(caption.isCaptionDisplayed(),"Failed: Caption is NOT displayed.");
    }



    @Test
    @DisplayName("TEST 4: Verify KEYPRESSES elements.")
    public void testKeyPress(){
        KeyPressesPage keyPressesPage = homepage.clickKeyPressesPage();
        keyPressesPage.enterTextKeyPressField("A" + Keys.BACK_SPACE);
        String resultTextSample = keyPressesPage.getResultText();
        System.out.println(resultTextSample);

        Assertions.assertEquals(resultTextSample,"You entered: BACK_SPACE","Failed: Incorrect result text.");

        //This test enter a Pi
//        keyPressesPage.enterPi();
//        Assertions.assertEquals(keyPressesPage.getResultText(),"You entered: P","Failed: Incorrect result text.");
    }


    @Test
    @DisplayName("TEST 5: Verify HORIZONTAL SLIDER elements.")
    public void testHorizontalSlider(){
        HorizontalSliderPage horizontalSliderPage = homepage.clickHorizontalSliderPage();
        horizontalSliderPage.selectSliderValue("3");
        String rangeResults = horizontalSliderPage.getRangeStringResults();

        //TODO: Fix this. Not moving the Horizontal slider using sendKeys
        Assertions.assertEquals(rangeResults,"3","Failed: Range Results NOT equal.");
    }




    //End of Class
}
