package com.example.ui.taskTwo;

import com.example.pages.FeedbackPage;
import com.example.ui.BaseUiTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FeedbackFormTest extends BaseUiTest {

    @Autowired
    FeedbackPage feedbackPage;

    @BeforeMethod
    public void openPage() {
        feedbackPage.open();
    }

    @Test
    public void userCanSendFeedback() {
        feedbackPage.fillName("John")
                .fillEmail("John.Doe@email.com")
                .fillMessage("I am very happy using your application!")
                .clickSendButton();
        Assert.assertTrue(feedbackPage.isConfirmationDisplayed());
    }

    @Test(dataProvider = "feedbackData")
    public void mandatoryFieldsValidation(String name, String email, String message) {
        feedbackPage.fillName(name)
                .fillEmail(email)
                .fillMessage(message)
                .clickSendButton();
        Assert.assertFalse(feedbackPage.isConfirmationDisplayed());
    }

    @DataProvider
    public static Object[][] feedbackData() {
        return new Object[][]{
                {"John", "John.Doe@email.com", EMPTY_STRING},
                {"Jane", EMPTY_STRING, "Test message"},
                {EMPTY_STRING, "Jane.Doe@email.com", "Test message", },
        };
    }

}
