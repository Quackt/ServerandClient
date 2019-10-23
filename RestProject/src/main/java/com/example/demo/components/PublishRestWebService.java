package com.example.demo.components;



import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

public class PublishRestWebService {
    public static void main(String[] args) {
        //框架内置Bean，放东西的，用就是了
        JAXRSServerFactoryBean jaxrsServerFactoryBean = new JAXRSServerFactoryBean();
        //设置我们的实现类class
        jaxrsServerFactoryBean.setResourceClasses(RestWebServiceImpl.class);
        //设置我们的实现对象，内部会通过动态代理完成远程调用模块
        jaxrsServerFactoryBean.setServiceBean(new RestWebServiceImpl());
        //写出我们的访问路径
        jaxrsServerFactoryBean.setAddress("http://127.0.0.1:12345/rest");
        //发布
        jaxrsServerFactoryBean.create();
    }
}
