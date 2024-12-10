package com.outlook.userInterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OutlookLoginPage {
    public static final Target EMAIL_TXT = Target.the("email field")
            .locatedBy("//input[@name='loginfmt']");
    public static final Target NEXT_BUTTON = Target.the("next button")
            .locatedBy("//input[@value='Next']");
    public static final Target PASSWORD_TXT = Target.the("password field")
            .locatedBy("//input[@name='passwd']");
    public static final Target SUBMIT_BUTTON = Target.the("sign-in button")
            .locatedBy("//button[@type='submit']");
    public static final Target OTP_TXT = Target.the("otp field")
            .locatedBy("//input[@name='otc']");
    public static final Target ACCEPT_BUTTON = Target.the("accept button to remember device")
            .located(By.id("acceptButton"));
}
