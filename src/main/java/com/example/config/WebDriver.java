package com.example.config;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;

public class WebDriver {

    public static void configBrowser() {
        Configuration.browser = Browsers.CHROME;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
    }
}
