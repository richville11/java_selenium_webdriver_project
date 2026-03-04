package testScenarios;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTests extends BaseTests {

    private static String usernameValue = "tomsmith";
    private static String passwordValue = "SuperSecretPassword!";
    private static String actualSecurePageTitleValue;
    private static String expectedSecurePageTitleValue = "You logged into a secure area!\n×";

    @Test
    @DisplayName("TEST 1: Verify Successful Login.")
    public void testSuccessLogin() throws InterruptedException {

        LoginPage loginPage = homepage.clickFormAuthenticationLink();
        loginPage.enterTextLoginId(usernameValue);
        loginPage.enterTextPassword(passwordValue);

        //Page Chaining model
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        actualSecurePageTitleValue = secureAreaPage.getSecureAreaPageTitleText();

        Assertions.assertEquals(expectedSecurePageTitleValue,actualSecurePageTitleValue,
                "Failed: SecureArea Page Text is NOT found.");

    }
}
