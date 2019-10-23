package com.example.demo.components;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface SoapWebService {
    @WebMethod
    public String isMatch(@WebParam(name="idNumber")String idNumber);
}
