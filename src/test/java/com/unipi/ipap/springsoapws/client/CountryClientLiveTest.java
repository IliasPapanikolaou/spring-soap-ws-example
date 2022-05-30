package com.unipi.ipap.springsoapws.client;

import com.unipi.ipap.springsoapws.generated.Currency;
import com.unipi.ipap.springsoapws.generated.GetCountryResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Ensure that the server - com.unipi.ipap.springsoapws.SpringSoapWsApplication - is running before executing this test
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CountryClientConfig.class, loader = AnnotationConfigContextLoader.class)
public class CountryClientLiveTest {

    @Autowired
    CountryClient client;

    @Test
    public void givenCountryService_whenCountryPoland_thenCapitalIsWarsaw() {
        GetCountryResponse response = client.getCountry("Poland");
        assertEquals("Warsaw", response.getCountry()
                .getCapital());
    }

    @Test
    public void givenCountryService_whenCountrySpain_thenCurrencyEUR() {
        GetCountryResponse response = client.getCountry("Spain");
        assertEquals(Currency.EUR, response.getCountry()
                .getCurrency());
    }
}