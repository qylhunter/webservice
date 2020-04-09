package com.demo.ws.server.cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

//@WebService(serviceName = "HelloCXFService", portName = "HelloCXFService", endpointInterface = "com.demo.ws.server.cxf.HelloCXFService", targetNamespace = "http://cxf.server.ws.demo.com/")
@WebService
public interface HelloCXFService {
    @WebMethod
    String hello(@WebParam(name = "hello") String hello);
}
