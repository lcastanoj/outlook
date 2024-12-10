package com.outlook.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import javax.crypto.SecretKey;

import com.outlook.utils.totp.OTPGenerator;
import com.outlook.utils.interfaces.OTPLogger;

public class SignIn implements Interaction {

    private final OTPGenerator otpGenerator;
    private final OTPLogger otpLogger;

    public SignIn(OTPGenerator otpGenerator, OTPLogger otpLogger) {
        this.otpGenerator = otpGenerator;
        this.otpLogger = otpLogger;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String otp = otpGenerator.generateOTP();
        long timeLeft = otpGenerator.calculateTimeLeft();

        actor.remember("otp", otp);
        otpLogger.logOTP(otp, timeLeft);
    }

    public static SignIn withMicrosoftProvider(SecretKey secretKey, OTPLogger otpLogger) {
        OTPGenerator otpGenerator = new OTPGenerator(secretKey);
        return Tasks.instrumented(SignIn.class, otpGenerator, otpLogger);
    }

}