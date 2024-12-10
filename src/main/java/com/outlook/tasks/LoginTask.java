package com.outlook.tasks;

import com.outlook.utils.LoggerConsola;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.outlook.userInterface.OutlookLoginPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.openqa.selenium.Keys.ENTER;

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
                Click.on(NEXT_BUTTON));
        actor.attemptsTo(
                WaitUntil.the(PASSWORD_TXT, isPresent()).forNoMoreThan(60).seconds(),
                Enter.theValue(password).into(PASSWORD_TXT),
                Click.on(SUBMIT_BUTTON)
        );

        String otp = actor.recall("otp");
        actor.attemptsTo(
                WaitUntil.the(OTP_TXT, isPresent()).forNoMoreThan(60).seconds(),
                Enter.theValue(otp).into(OTP_TXT).thenHit(ENTER)
        );

        actor.attemptsTo(
                Click.on(ACCEPT_BUTTON)
        );

        actor.attemptsTo(
                Click.on(LBL_MENSAJE_SURA_CODIGO),
                WaitUntil.the(LBL_CODIGO_DFA, isPresent()).forNoMoreThan(60).seconds()
        );

        String codigoDFA = Text.of(LBL_CODIGO_DFA).answeredBy(actor).toString();
        LoggerConsola.imprimirInformacionLogger("Código DFA obtenido: " + codigoDFA);
    }

    public static LoginTask withCredentials(String email, String password) {
        return instrumented(LoginTask.class, email, password);
    }
}
