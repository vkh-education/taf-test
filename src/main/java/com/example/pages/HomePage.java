package com.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class HomePage implements IPage{

    private SelenideElement unique = $("#unique");

    @Override
    public void open() {

    }

    @Override
    public boolean isOpened() {
        return unique.is(Condition.visible);
    }
}
