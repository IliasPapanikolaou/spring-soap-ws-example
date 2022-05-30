package com.unipi.ipap.springsoapws.client;

import com.unipi.ipap.springsoapws.generated.GetCountryRequest;
import com.unipi.ipap.springsoapws.generated.GetCountryResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class CountryClient extends WebServiceGatewaySupport {
    public GetCountryResponse getCountry(String country) {
        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
        return response;
    }
}
