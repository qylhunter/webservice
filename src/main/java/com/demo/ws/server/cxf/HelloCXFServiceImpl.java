package com.demo.ws.server.cxf;

import javax.jws.WebService;

//@WebService(serviceName = "HelloCXFService", portName = "HelloCXFService", endpointInterface = "com.demo.ws.server.cxf.HelloCXFService", targetNamespace = "http://cxf.server.ws.demo.com/")
@WebService
public class HelloCXFServiceImpl implements HelloCXFService {
    @Override
    public String hello(String hello) {
        System.out.println("receive client: " + hello);
        return "hello, ws cxf client!";
    }
}
