package com.ws.soap.server.jws;


import javax.jws.WebService;

@WebService
public class HelloJwsServiceImpl implements HelloJwsService {
    @Override
    public String hello(String message) {
        System.out.println("receive jws client: " + message);
        return "hello, ws jws client!";
    }
}
