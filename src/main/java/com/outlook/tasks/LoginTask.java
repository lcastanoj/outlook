package com.outlook.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.outlook.userInterface.OutlookLoginPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginTask implements Task {
    private final String email;
    private final String password;

    public LoginTask(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(email).into(EMAIL_TXT),
                Click.on(NEXT_BUTTON),
                Enter.theValue(password).into(PASSWORD_TXT),
                Click.on(SIGN_IN_BUTTON),
                Click.on(ACCEPT_BUTTON)
        );
    }

    public static LoginTask withCredentials(String email, String password) {
        return instrumented(LoginTask.class, email, password);
    }
}
