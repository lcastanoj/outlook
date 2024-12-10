package com.outlook.utils.totp;

import com.outlook.utils.LoggerConsola;
import com.outlook.utils.interfaces.OTPLogger;

public class ConsoleOTPLogger implements OTPLogger {

    @Override
    public void logOTP(String otp, long timeLeft) {
        LoggerConsola.imprimirInformacionLogger("OTP generado: {}. Tiempo restante: {} segundos", otp, timeLeft);
    }

}
