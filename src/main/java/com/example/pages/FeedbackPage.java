package com.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.springframework.beans.factory.annotation.Value;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class FeedbackPage implements IPage{

    private SelenideElement nameField = $("#name");
    private SelenideElement emailField = $("#email");
    private SelenideElement messageField = $("#message");
    private SelenideElement sendBtn = $("#sendBtn");
    private SelenideElement confirmationBox = $("#confirmation");

    @Value("$url.feedbackPage")
    private String url;

    @Override
    public void open() {
        Selenide.open(url);
    }

    @Override
    public boolean isOpened() {
        return sendBtn.is(Condition.visible);
    }

    public FeedbackPage fillName(String name){
        nameField.shouldBe(Condition.visible).sendKeys(name);
        return this;
    }

    public FeedbackPage fillEmail(String email){
        emailField.shouldBe(Condition.visible).sendKeys(email);
        return this;
    }

    public FeedbackPage fillMessage(String message){
        messageField.shouldBe(Condition.visible).sendKeys(message);
        return this;
    }

    public void clickSendButton() {
        sendBtn.shouldBe(Condition.visible).click();
    }

    // assume confirmation message is displayed on the same page
    public boolean isConfirmationDisplayed() {
        return confirmationBox.is(Condition.visible, Duration.ofSeconds(2L));
    }


}
