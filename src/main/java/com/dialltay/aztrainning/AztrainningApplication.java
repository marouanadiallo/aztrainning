package com.dialltay.aztrainning;

import com.azure.security.keyvault.secrets.SecretClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AztrainningApplication {

    private final SecretClient secretClient;

    public AztrainningApplication(SecretClient secretClient) {
        this.secretClient = secretClient;
    }

    public static void main(String[] args) {
		SpringApplication.run(AztrainningApplication.class, args);
	}

    @GetMapping("/secrets")
    public String getSecret() {
        return this.secretClient.getSecret("YourName").getValue();
    }

}
