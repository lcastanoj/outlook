package com.outlook.utils.totp;

import com.eatthepath.otp.TimeBasedOneTimePasswordGenerator;
import org.apache.commons.codec.binary.Base32;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class KeyManager {

    private KeyManager() {
        throw new IllegalStateException("Utility class");
    }

    public static SecretKey stringToSecretKey(String encodedKey) {
        String normalizedKey = encodedKey.replace(" ", "");
        Base32 base32 = new Base32();
        byte[] decodedKey = base32.decode(normalizedKey);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, "HmacSHA512");
    }

    public static SecretKey generateSecretKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(
                    TimeBasedOneTimePasswordGenerator.TOTP_ALGORITHM_HMAC_SHA512
            );
            return keyGenerator.generateKey();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}