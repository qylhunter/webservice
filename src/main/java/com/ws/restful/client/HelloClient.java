package com.ws.restful.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.ws.restful.server.service.HelloService;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.impl.ResponseImpl;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HelloClient {

    public static void main(String[] args) throws IOException {
        String baseAddress = "http://localhost:8011/ws/rest";

        List<Object> providerList = new ArrayList<Object>();
        providerList.add(new JacksonJsonProvider());

        JacksonJsonProvider jsonProvider = new JacksonJsonProvider();


//        //JSR 1.1及以下，未验证
//        HelloService helloService = JAXRSClientFactory.create(baseAddress, HelloService.class, providerList);
//        Response hello = helloService.hello("hello");
//        System.out.println(hello);
//
//        Response hi = helloService.hi("1");
//        System.out.println(hi);
//
//        Response query = helloService.query("1");
//        System.out.println(query);


        //JSR 2.2以上，以验证
        com.ws.restful.server.model.Response request = new com.ws.restful.server.model.Response();
        request.setSessionId("1");
        request.setMessage("www");
        request.setCode("1");
        request.setId("11");
        com.ws.restful.server.model.Response response = ClientBuilder.newClient().register(jsonProvider)
                .target(baseAddress).path("/test")
                .request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .post(Entity.entity("", MediaType.APPLICATION_JSON), new GenericType<com.ws.restful.server.model.Response>(){});
        System.out.println(response);


        com.ws.restful.server.model.Response helloResponse = ClientBuilder.newClient().register(jsonProvider)
                .target(baseAddress).path("/hello")
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.entity(request, MediaType.APPLICATION_JSON), new GenericType<com.ws.restful.server.model.Response>(){});
        System.out.println(helloResponse);
    }

}
