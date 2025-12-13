package com.dialltay.aztrainning;

import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.spring.cloud.autoconfigure.implementation.keyvault.common.AzureKeyVaultProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class SecretClientConfiguration {

    @Bean
    @Profile("prod")
    public SecretClient secretClient(AzureKeyVaultProperties properties) {
        return new com.azure.security.keyvault.secrets.SecretClientBuilder()
                .vaultUrl(properties.getEndpoint())
                .credential(new com.azure.identity.DefaultAzureCredentialBuilder().build())
                .buildClient();
    }
}
