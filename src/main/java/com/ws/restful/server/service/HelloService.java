package com.ws.restful.server.service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


public interface HelloService {

    @POST
    @Path("/hello")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    javax.ws.rs.core.Response hello(String data);

    @POST
    @Path("/test")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    javax.ws.rs.core.Response test();

    @GET
    @Path("/hi/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    javax.ws.rs.core.Response hi(@PathParam("id")String id);


    @GET
    @Path("/search{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    javax.ws.rs.core.Response query(@QueryParam("name")String name);

}
