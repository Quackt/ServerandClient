package com.example.demo.components;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import javax.xml.namespace.QName;

public class CXFClient {
    /*
    public static void main(String[] args) {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8080/soap/idMatch?wsdl");

        try{
            String namespaceURI = "http://components.demo.example.com/";
            String methodName = "isMatch";
            String param = "421002198906051213";
            Object[] result = null;
            result = client.invoke(new QName(namespaceURI,methodName),param);
            System.out.println(result[0]);
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
}
