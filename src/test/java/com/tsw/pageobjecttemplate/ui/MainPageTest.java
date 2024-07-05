package com.tsw.pageobjecttemplate.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.commands.PressEnter;
import com.tsw.pageobjecttemplate.pages.MainPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://todomvc.com/examples/react/dist/#/");
    }

    @Test
    public void userToCreateNewToDoActionThenThisActionIsShownOnTheList() {
        mainPage.inputField.click();
        mainPage.inputField.setValue("Wake up");
        mainPage.inputField.pressEnter();
        mainPage.itemCreated.shouldBe(visible);
    }

    @Test
    public void userIsAbleToCreateMultipleActionsAndThenTheActionsAreListedAllTogether() {

        String todoFirstItem = "1.Make a cup of coffee";
        String todoSecondItem = "2.Do some exersise";
        //String locaterTemplate = label[@data-testid='todo-item-label' and contains(text(), '1.Make a cup of coffee')]
        //To build unic locator
        //To build second locator
        //Assert that those locater are presented - so they are unic
        mainPage.inputField.click();
        mainPage.inputField.setValue("1.Make a cup of coffee");
        mainPage.inputField.pressEnter();
        mainPage.inputField.setValue("2.Do some exersise");
        mainPage.inputField.pressEnter();
        mainPage.itemCreated.shouldBe(visible);
    }

    //Homework 19

    @Test
    public void userIsAbleToMarkTheActionsAsCompleted() {
        mainPage.inputField.click();
        Selenide.sleep(1000);
        mainPage.inputField.setValue("1.Make a cup of coffee");
        Selenide.sleep(1000);
        mainPage.inputField.pressEnter();
        Selenide.sleep(1000);
        mainPage.itemComplete.click();
        Selenide.sleep(1000);
    }

    @Test
    public void userIsAbleToClickClearCompletedButton() {
        mainPage.inputField.click();
        Selenide.sleep(1000);
        mainPage.inputField.setValue("2.Do some exercises");
        Selenide.sleep(1000);
        mainPage.inputField.pressEnter();
        Selenide.sleep(1000);
        mainPage.itemComplete.click();
        Selenide.sleep(1000);
       // mainPage.clearCompletedButton.click();
       // Selenide.sleep(1000);
        mainPage.popupCross.click();
        Selenide.sleep(1000);
    }
}
