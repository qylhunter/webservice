package com.ws.restful.server.service;

import com.alibaba.fastjson.JSONPObject;
import com.ws.restful.server.model.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public interface HelloService {

    @POST
    @Path("/hello")
    @Consumes(MediaType.APPLICATION_JSON)
    void hello(String data);

    @GET
    @Path("/hi/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response hi(@PathParam("id")String id);


    @GET
    @Path("/search{name}")
//    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response query(@QueryParam("name")String name);



}
