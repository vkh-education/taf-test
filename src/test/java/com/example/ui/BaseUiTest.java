package com.example.ui;

import com.codeborne.selenide.Selenide;
import com.example.BaseTest;
import com.example.config.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class BaseUiTest extends BaseTest {

    @BeforeTest
    public static void setup() {
        WebDriver.configBrowser();
    }

    @AfterMethod
    public void closeBrowser() {
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWindow();
    }
}
