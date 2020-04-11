package com.ws.restful.server;

import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/helloService")
@Component
public class HelloService {

    @POST
    @Path("/hello")
    @Consumes(MediaType.APPLICATION_JSON)
    public String hello(String data) {
        System.out.println("receive client data: " + data);
        return "hello, i am ws restful server!";
    }

    @GET
    @Path("/hi")
    @Consumes(MediaType.APPLICATION_JSON)
    public String hi() {
        System.out.println("receive client request!" );
        return "hello, i am ws restful server!";
    }

}
