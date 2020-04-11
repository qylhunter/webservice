package com.ws.soap.server.cxf;


import com.ws.soap.server.model.ResponseUtil;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "HelloCXFService", portName = "HelloCXFService", endpointInterface = "com.ws.soap.server.cxf.HelloCXFService", targetNamespace = "http://cxf.server.soap.ws.com/")
//@WebService
public class HelloCXFServiceImpl implements HelloCXFService {
    @Override
    public String hello(@WebParam(name = "hello") String hello) {
        System.out.println("receive client: " + hello);
        return ResponseUtil.success();
    }
}
