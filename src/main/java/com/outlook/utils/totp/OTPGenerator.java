package com.outlook.utils.totp;

import com.eatthepath.otp.TimeBasedOneTimePasswordGenerator;
import com.outlook.utils.interfaces.TOTPInterface;

import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.time.Duration;
import java.time.Instant;

public class OTPGenerator implements TOTPInterface {

    private final SecretKey secretKey;
    private final Duration timeStep;
    private final TimeBasedOneTimePasswordGenerator totpGenerator;

    public OTPGenerator(SecretKey secretKey) {
        this.secretKey = secretKey;
        this.timeStep = Duration.ofSeconds(30);
        this.totpGenerator = new TimeBasedOneTimePasswordGenerator(timeStep);
    }

    @Override
    public String generateOTP() {
        try {
            return String.valueOf(totpGenerator.generateOneTimePassword(secretKey, Instant.now()));
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long calculateTimeLeft() {
        Instant now = Instant.now();
        long elapsedSeconds = now.getEpochSecond() % timeStep.getSeconds();
        return timeStep.getSeconds() - elapsedSeconds;
    }

}
