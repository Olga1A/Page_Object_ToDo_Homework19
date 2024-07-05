package com.tsw.pageobjecttemplate.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://todomvc.com/examples/react/dist/#/active/
public class MainPage {

    public SelenideElement inputField = $("[data-testid='text-input']");
    public SelenideElement itemCreated = $("[data-testid='todo-item-label']");

//Homework 19

    public SelenideElement itemComplete = $("[data-testid='todo-item-toggle']");
    public SelenideElement popupCross = $("[data-testid='todo-item-button']");

    //public SelenideElement clearCompletedButton = $("[data-testid='footer-navigation']//svg[contains(@class,'clear-completed')]");
    //public SelenideElement clearCompletedButton = $("[data-class='clear-completed']");
    }




