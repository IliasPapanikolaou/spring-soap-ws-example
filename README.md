### Testing Request
To test a request, we create the following file and name it request.xml:
```XML
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:gs="http://www.unipi.com/ipap/springsoapws/generated">
    <soapenv:Header/>
    <soapenv:Body>
        <gs:getCountryRequest>
          <gs:name>Spain</gs:name>
        </gs:getCountryRequest>
    </soapenv:Body>
</soapenv:Envelope>
```

### Testing
To send the request to our test server, we could use external tools like SoapUI or the Google Chrome extension Wizdler. 
Another way is to run the following command in our shell:
```Bash
curl --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws
```

The resulting response might not be easy to read without indentation or line breaks.

To see it formatted, we can copy paste it to our IDE or another tool. 
If we've installed xmllib2, we can pipe the output of our curl command to xmllint:
```Bash
curl [command-line-options] | xmllint --format -
```
### Response sample
The response should contain information about Spain:
```XML
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
<SOAP-ENV:Header/>
<SOAP-ENV:Body>
    <ns2:getCountryResponse xmlns:ns2="http://www.unipi.com/ipap/springsoapws/generated">
        <ns2:country>
            <ns2:name>Spain</ns2:name>
            <ns2:population>46704314</ns2:population>
            <ns2:capital>Madrid</ns2:capital>
            <ns2:currency>EUR</ns2:currency>
        </ns2:country>
    </ns2:getCountryResponse>
</SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```