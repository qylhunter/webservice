package com.ws.restful.client;

import com.alibaba.fastjson.JSONObject;
import com.sun.jersey.api.client.WebResource;

public class HelloClient {
    public static void main(String[] args) {
//        Client client = ClientFactory.newClient();
//        WebTarget target = client.target("http://localhost:8099/HelloService/hello");
        Hello hello = new Hello();
        hello.setHello("hello");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello", "hello");
//        Entity entity = Entity.entity(hello, MediaType.APPLICATION_JSON_TYPE);
//        Response post = target.request().post(entity);
//        System.out.println(post.getStatus());
        com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create();
        WebResource resource = client.resource("http://localhost:8011/helloService/hi/hi");
        String s = resource.get(String.class);
        System.out.println(s);
//        WebResource resource = client.resource("http://localhost:8011/helloService/hello");
//        String post = resource.entity(jsonObject, MediaType.APPLICATION_JSON_TYPE).post(String.class);
//        System.out.println(post);
    }



}
class Hello {
    private String hello;

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
