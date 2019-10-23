package com.example.demo.components;

import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import java.util.regex.Pattern;

@WebService(serviceName="SoapWebService",
        targetNamespace="http://components.demo.example.com",
        portName = "soaPortName"
        )
@Component
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class SoapWebServiceImpl implements SoapWebService{
    @Override
    @WebMethod
    @WebResult(name="result")
    public String isMatch(String idNumber) {
        String pattern = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
        return Pattern.matches(pattern,idNumber)? "success":"fail";
    }
}
