package com.cryto.cryptage.web.controller;

import com.cryto.cryptage.service.interfaces.Icrypto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Tag(name="Generate HMAC", description = "Crytage avec HMac sous spring Boot")
@RestController
@RequestMapping(path = "/Generate_avec_Hmac")
@RequiredArgsConstructor
public class CryptoController {

    private final Icrypto icrypto;

    @GetMapping(path = "/generer-hmac/{keyShared}")
    public String genarateHmac(@PathVariable String keyShared, @RequestParam String message) throws NoSuchAlgorithmException, InvalidKeyException {
        return icrypto.generateHMAC(message, keyShared);
    }

    @GetMapping(path = "/verifier-hmac")
    public boolean verifierHmac(@RequestParam String message, @RequestParam String secretKey, String hmac) throws Exception {
        return icrypto.verifyHMAC(message, secretKey, hmac);
//        R2GS9vUC5/B4cAJM05h3cK7qXFv18C451Hmlme+JYF0=
//        R2GS9vUC5/B4cAJM05h3cK7qXFv18C451Hmlme+JYF0=
    }

}
