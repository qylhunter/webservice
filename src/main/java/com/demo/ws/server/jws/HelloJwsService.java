package com.demo.ws.server.jws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * webservice vehicle
 */
@WebService
public interface HelloJwsService {
    @WebMethod(operationName = "hello")
    String hello(@WebParam(name = "hello") String hello);
}
