package com.example.pages;

import com.codeborne.selenide.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Component
public class LoginPage implements IPage{

    private SelenideElement userNameField = $("#Username");
    private SelenideElement passwordField = $("#pwd");
    private SelenideElement loginBtn = $x(".//button[@data-ui-test='customer-login-button']");
    private SelenideElement alertBox = $(".alert");

    @Value("${url.loginPage}")
    private String url;

    @Override
    public void open() {
        Selenide.open(url);
        loginBtn.shouldBe(Condition.visible);
    }

    @Override
    public boolean isOpened() {
        return loginBtn.is(Condition.visible);
    }

    public void fillUserName(String value) {
        userNameField.sendKeys(value);
    }

    public void fillPassword(String value) {
        passwordField.sendKeys(value);
    }

    public void clickLogin() {
        loginBtn.click();
    }

    public boolean isAlertDisplayed() {
        return alertBox.is(Condition.visible, Duration.ofSeconds(1L));
    }

    public String getAlertMessage() {
        return alertBox.shouldBe(Condition.visible).getText();
    }

}
