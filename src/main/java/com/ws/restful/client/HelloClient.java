package com.ws.restful.client;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class HelloClient {

    public static void main(String[] args) {
        String baseAddress = "http://localhost:8011/ws/rest";

        List<Object> providerList = new ArrayList<Object>();
        providerList.add(new JacksonJsonProvider());


        //JSR 1.1及以下，未验证
//        HelloService helloService = JAXRSClientFactory.create(baseAddress, HelloService.class, providerList);
//        Response hello = helloService.hello("hello");
//        System.out.println(hello);
//
//        Response hi = helloService.hi("1");
//        System.out.println(hi);
//
//        Response query = helloService.query("1");
//        System.out.println(query);


        //JSR 2.2以上

//        Response response = ClientBuilder.newClient().register(providerList)
//                .target(baseAddress).path("/hi/1")
//                .request(MediaType.APPLICATION_JSON).get();
//        System.out.println(response.getStatus());
//        System.out.println(response.getEntity());

        com.ws.restful.server.model.Response response1 = new com.ws.restful.server.model.Response();
        response1.setSessionId("1");
        response1.setMessage("www");
        response1.setCode("1");
        response1.setId("11");
        Entity entity = Entity.entity(response1, MediaType.APPLICATION_JSON);
        Response post = ClientBuilder.newClient().register(providerList)
                .target(baseAddress).path("/hello")
                .request(MediaType.APPLICATION_JSON).post(entity);
        System.out.println(post.getStatus());

    }



}
