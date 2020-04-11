package com.ws.soap.server.cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

//@WebService(serviceName = "HelloCXFService", portName = "HelloCXFService", endpointInterface = "com.ws.soap.server.cxf.HelloCXFService", targetNamespace = "http://cxf.server.soap.ws.com/")
@WebService
public interface HelloCXFService {
    @WebMethod
    String hello(@WebParam(name = "hello") String hello);
}
