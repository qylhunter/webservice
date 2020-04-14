package com.ws.restful.server.service;

public class HelloServiceImpl implements HelloService {


    @Override
    public javax.ws.rs.core.Response hello(String data) {
        System.out.println("receive client data: " + data);
        return javax.ws.rs.core.Response.ok(reponse()).build();
    }

    @Override
    public javax.ws.rs.core.Response test() {
        System.out.println("client post");
        return javax.ws.rs.core.Response.ok(reponse()).build();
    }

    @Override
    public javax.ws.rs.core.Response hi(String id) {
        System.out.println("receive client request:" + id);
        return javax.ws.rs.core.Response.ok(reponse()).build();
    }

    @Override
    public javax.ws.rs.core.Response query(String name) {
        return javax.ws.rs.core.Response.ok(reponse()).build();
    }

    private com.ws.restful.server.model.Response reponse() {
        com.ws.restful.server.model.Response response = new com.ws.restful.server.model.Response();
        response.setSessionId("1");
        response.setMessage("www");
        response.setCode("1");
        response.setId("11");
        return response;
    }

}
