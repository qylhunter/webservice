package com.ws.soap.server.cxf;

import javax.jws.WebService;

//两种书写方式没有区别，主要区别的Endpoint的发布上。serviceName，portName只是自定义修改wsdl中的默认显示
//@WebService(serviceName = "HiCXFService", portName = "HiCXFServicePort", endpointInterface = "com.demo.ws.server.cxf.HiCXFService", targetNamespace = "http://cxf.server.ws.demo.com/")
@WebService(portName = "HiCXFServicePort", serviceName = "HiCXFService")
public class HiCXFServiceImpl implements HiCXFService {
    @Override
    public String hi(String hi) {
        System.out.println("receive client: " + hi);
        return "hello, ws cxf client!";
    }
}
