package com.unipi.ipap.springsoapws;

import com.unipi.ipap.springsoapws.generated.GetCountryRequest;
import com.unipi.ipap.springsoapws.generated.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/*
* @Endpoint – registers the class with Spring WS as a Web Service Endpoint
* @PayloadRoot – defines the handler method according to the namespace and localPart attributes
* @ResponsePayload – indicates that this method returns a value to be mapped to the response payload
* @RequestPayload – indicates that this method accepts a parameter to be mapped from the incoming request
**/

@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://www.unipi.com/ipap/springsoapws/generated";

    private CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));
        return response;
    }
}
