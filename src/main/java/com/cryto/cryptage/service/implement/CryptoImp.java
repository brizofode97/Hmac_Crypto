package com.cryto.cryptage.service.implement;

import com.cryto.cryptage.service.interfaces.Icrypto;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class CryptoImp implements Icrypto {

    //OPTIMIZE: Declaration de constante pour le cryptage
    private static final String ENCRYPTION_ALGORITHM = "AES";

    private final String HMAC_ALGORITHM = "HmacSHA256";

    @Override
    public String generateHMAC(String message, String secret) throws NoSuchAlgorithmException, InvalidKeyException {

        Mac mac = Mac.getInstance(HMAC_ALGORITHM);

        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), HMAC_ALGORITHM);
        mac.init(secretKeySpec);

        byte[] hmacBytes = mac.doFinal(message.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hmacBytes);

    }

    @Override
    public boolean verifyHMAC(String message, String secret, String hmac) throws NoSuchAlgorithmException, InvalidKeyException {
        String generatedHmac = generateHMAC(message, secret);
        return generatedHmac.equals(hmac);
    }

    @Override
    public String encrypte(String message){
        return "";
    }
}
