package com.ws.soap.server.model;
import com.ws.soap.server.utils.JavaBeanToXml;
import lombok.SneakyThrows;

public class ResponseUtil {

    @SneakyThrows
    public static String success(){
        Response response = new Response();
        response.setCode("0");
        response.setMessage("成功");
        response.setSessionId("123456789");
        return JavaBeanToXml.convertToXml(response, "UTF-8", true);
    }

    @SneakyThrows
    public static String failed(){
        Response response = new Response();
        response.setCode("-1");
        response.setMessage("失败");
        response.setSessionId("123456789");
        return JavaBeanToXml.convertToXml(response, "UTF-8", true);
    }

}
