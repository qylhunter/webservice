package com.demo.ws.server.cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface HiCXFService {
    @WebMethod
    String hi(@WebParam(name = "hi") String hi);
}
