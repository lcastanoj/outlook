package com.outlook.stepDefinitions.hooks;

import io.cucumber.java.Before;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

 public class Hooks extends PageObject {
    @Managed
    WebDriver driver;

    @Before
    public void setUp() {
        driver = getDriver();
        setTheStage(new OnlineCast());
        theActorCalled("user").whoCan(BrowseTheWeb.with(driver));
    }
}
