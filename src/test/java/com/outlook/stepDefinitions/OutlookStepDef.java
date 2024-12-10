package com.outlook.stepDefinitions;

import com.outlook.interactions.SignIn;
import com.outlook.tasks.LoginTask;
import com.outlook.tasks.OpenBrowserTask;
import com.outlook.utils.interfaces.OTPLogger;
import com.outlook.utils.totp.ConsoleOTPLogger;
import com.outlook.utils.totp.KeyManager;
import io.github.cdimascio.dotenv.Dotenv;
import io.cucumber.java.en.*;

import java.util.Objects;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class OutlookStepDef {

    @Given("the user is on the Outlook login page")
    public void theUserIsOnTheOutlookLoginPage() {
        theActorCalled("Test").wasAbleTo(
                OpenBrowserTask.url("https://outlook.office.com/mail/")
        );
    }

    @When("they enter their email {string} and password {string}")
    public void theyEnterTheirEmailAndPassword(String email, String password) {
        theActorInTheSpotlight().attemptsTo(LoginTask.withCredentials(email, password));
    }

    @And("the user gets the two step verification")
    public void theUserGetsTheTwoStepVerification() {

        Dotenv dotenv = Dotenv.load();

        OTPLogger otpLogger = new ConsoleOTPLogger();

        String secretKey = Objects.requireNonNull(dotenv.get("SECRET_KEY"));

        theActorInTheSpotlight().attemptsTo(
                SignIn.withMicrosoftProvider(
                        KeyManager.stringToSecretKey(secretKey),
                        otpLogger
                )
        );
    }

    @Then("they should see their inbox")
    public void theyShouldSeeTheirInbox() {
    }
}



