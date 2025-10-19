package com.example.ui.taskOne;

import com.example.pages.HomePage;
import com.example.pages.LoginPage;
import com.example.ui.BaseUiTest;
import com.example.utilities.SecretsReader;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@SpringBootTest
public class LoginTest extends BaseUiTest {

    @Autowired
    LoginPage loginPage;

    @Autowired
    HomePage homePage;

    @BeforeMethod
    public void openPage() {
        loginPage.open();
    }

    @Test
    public void userCanLogin() {
        loginPage.fillUserName(SecretsReader.getProperty("username"));
        loginPage.fillUserName(SecretsReader.getProperty("password"));
        loginPage.clickLogin();
        Assert.assertFalse(loginPage.isAlertDisplayed());
        Assert.assertTrue(homePage.isOpened());
    }

    @Test
    public void inactiveUserCantLogIn() {
        // use different assertion verifying that home page not opened and appropriate message displayed
    }

    @Test(dataProvider = "userData")
    public void loginValidations(String userName, String password) {
        loginPage.fillUserName(SecretsReader.getProperty(userName));
        loginPage.fillUserName(SecretsReader.getProperty(password));
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isAlertDisplayed());
        Assert.assertTrue(loginPage.getAlertMessage().contains("Invalid login/password"));
    }

    @DataProvider
    public static Object[][] userData() {
        return new Object[][]{
                {SecretsReader.getProperty("username"), RandomStringUtils.randomAlphanumeric(1, 8)},
                {RandomStringUtils.randomAlphanumeric(1, 8), SecretsReader.getProperty("password")},
                {SecretsReader.getProperty("username"), ""},
                {"", SecretsReader.getProperty("password")},
                {RandomStringUtils.randomAlphanumeric(1, 8), RandomStringUtils.randomAlphanumeric(1, 8)},
                {"", ""}
        };
    }
}
