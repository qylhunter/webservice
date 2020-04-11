package com.ws.restful.server.service;

import com.alibaba.fastjson.JSONPObject;
import com.ws.restful.server.model.Response;

import java.util.ArrayList;
import java.util.List;

public class HelloServiceImpl implements HelloService {


    @Override
    public void hello(String data) {
        System.out.println("receive client data: " + data);
//        Response response = new Response();
//        response.setId("1");
//        response.setCode("123");
//        response.setMessage("success");
//        response.setSessionId("11111");
//        List list = new ArrayList();
//        list.add(response);
//        return null;
    }

    @Override
    public Response hi(String id) {
        System.out.println("receive client request:" + id);
        Response response = new Response();
        response.setId("1");
        response.setCode("123");
        response.setMessage("success");
        response.setSessionId("11111");
        List<Response> list = new ArrayList<>();
        list.add(response);
//        JSONPObject jsonpObject = new JSONPObject("ok", list);
        return response;
    }

    @Override
    public Response query(String name) {
        Response response = new Response();
        response.setId("1");
        response.setCode("123");
        response.setMessage("success");
        response.setSessionId("11111");
        return response;
    }

}
