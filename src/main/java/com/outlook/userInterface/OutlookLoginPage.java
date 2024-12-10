package com.outlook.userInterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OutlookLoginPage {
    public static final Target EMAIL_TXT = Target.the("email field")
            .locatedBy("#i0116");
    public static final Target NEXT_BUTTON = Target.the("next button")
            .locatedBy("#idSIButton9");
    public static final Target PASSWORD_TXT = Target.the("password field")
            .locatedBy("#i0118");
    public static final Target SIGN_IN_BUTTON = Target.the("sign-in button")
            .locatedBy("#idSIButton9");
    public static final Target ACCEPT_BUTTON = Target.the("accept button to remember device")
            .located(By.id("acceptButton"));
}
