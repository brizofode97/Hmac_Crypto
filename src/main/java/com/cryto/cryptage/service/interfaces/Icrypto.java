package com.cryto.cryptage.service.interfaces;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public interface Icrypto {

    String generateHMAC(String message, String secret) throws NoSuchAlgorithmException, InvalidKeyException;
    boolean verifyHMAC(String message, String secret, String hmac) throws Exception;
    String encrypte(String message);

}
