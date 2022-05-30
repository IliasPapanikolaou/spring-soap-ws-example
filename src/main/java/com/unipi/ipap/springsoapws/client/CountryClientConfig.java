package com.unipi.ipap.springsoapws.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CountryClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.unipi.ipap.springsoapws.generated");
        return marshaller;
    }

    @Bean
    public CountryClient countryClient(Jaxb2Marshaller marshaller) {
        CountryClient countryClient = new CountryClient();
        countryClient.setDefaultUri("http://localhost:8080/ws");
        countryClient.setMarshaller(marshaller);
        countryClient.setUnmarshaller(marshaller);
        return countryClient;
    }
}
