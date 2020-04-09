package com.demo.ws.client.cxf;

import com.demo.ws.server.cxf.HelloCXFService;
import com.demo.ws.server.cxf.HiCXFService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * client
 * 只有方法1是有wadl地址即可调用方法，其他均需要根据wsdl生成客户端代码
 */
public class WsCxfClient {

    public static void main(String[] args) throws Exception {
//        method1();
//        method2();
        method3();
//        method4();
//        method5();
    }

    //动态调用
    //对于服务端接口和接口实现类，可使用注解@WebService标注的方式：
    //1、接口使用@WebService注解，并加上serviceName/portName，endpointInterface，targetNamespace属性；而接口实现类可不用@WebService注解标注
    //2、接口实现类只用@WebService注解，而接口实现类使用@WebService注解并加上serviceName/portName，endpointInterface，targetNamespace属性
    public static void method1() throws Exception {
        JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
        Client client = clientFactory.createClient("http://localhost:8099/service/helloCxf?wsdl");

        Object[] objects = client.invoke("hello", "hello, ws cxf server");
        System.out.println("receive from ws cxf server: " + objects[0].toString());
    }


    //调用方式二，通过接口协议获取数据类型
    //对于服务端接口和接口实现类，可使用注解@WebService标注的方式：
    //只支持在接口实现类的注解@WebService加上serviceName/portName，endpointInterface，targetNamespace属性，接口用注解@WebService；
    //如果服务端的@WebService的portName，endpointInterface，targetNamespace标注在接口上，则会报如下错（放在实现类上则不会）：
    // javax.xml.ws.WebServiceException: Attributes portName, serviceName and endpointInterface are not allowed in the @WebService annotation of an SEI.
    public static void method2() throws Exception {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setAddress("http://localhost:8099/service/helloCxf?wsdl");
        jaxWsProxyFactoryBean.setServiceClass(HelloCXFService.class);

        HelloCXFService helloCXFService = (HelloCXFService) jaxWsProxyFactoryBean.create();
        String hello = helloCXFService.hello("hello, webservice cxf server");
        System.out.println("receive from ws cxf server: " + hello);
    }


    //调用方式三，通过接口协议获取数据类型,设置链接超时和响应时间
    //对于服务端接口和接口实现类，可使用注解@WebService标注的方式：
    //只支持在接口实现类的注解@WebService加上serviceName/portName，endpointInterface，targetNamespace属性，接口用注解@WebService；
    //如果服务端的@WebService的portName，endpointInterface，targetNamespace标注在接口上，则会报如下错（放在实现类上则不会）：
    // javax.xml.ws.WebServiceException: Attributes portName, serviceName and endpointInterface are not allowed in the @WebService annotation of an SEI.
    public static void method3() throws Exception {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setAddress("http://localhost:8099/service/helloCxf?wsdl");
        jaxWsProxyFactoryBean.setServiceClass(HelloCXFService.class);

        HelloCXFService helloCXFService = (HelloCXFService) jaxWsProxyFactoryBean.create(); // 创建客户端对象
        Client proxy = ClientProxy.getClient(helloCXFService);
        HTTPConduit conduit = (HTTPConduit) proxy.getConduit();
        HTTPClientPolicy policy = new HTTPClientPolicy();
        policy.setConnectionTimeout(1000);
        policy.setReceiveTimeout(1000);
        conduit.setClient(policy);

        String hello = helloCXFService.hello("hello, webservice cxf server");
        System.out.println("receive from ws cxf server: " + hello);
    }

    //自配式调用
    private static void method4() throws MalformedURLException {
        URL url = new URL("http://localhost:8066/service/hiCxf?wsdl");
        //服务描述中服务端点的限定名称  两个参数分别为：命名空间 服务名
        QName qName = new QName("http://cxf.server.ws.demo.com/", "HiCXFService");
        Service service = Service.create(url, qName);
        //获得Hiservice的实现类对象，localPart参数是service name下的port name
        HiCXFService hiCXFServicePort = service.getPort(new QName("http://cxf.server.ws.demo.com/", "HiCXFServicePort"), HiCXFService.class);
        System.out.println("receive from ws cxf server: " + hiCXFServicePort.hi("hello, ws cxf server!"));
    }

    //使用jdk自带wsimport指令根据wsdl文件生成的客户端代码，使用相应的对象调用实现远程调用。
    private static void method5() {
//        HelloCXFServiceImpl helloService = new HelloCXFServiceImpl();
//        HelloCXFService helloServiceImplPort = helloService.getHelloJwsServiceImplPort();
//        String hello = helloServiceImplPort.hello("hello, ws jws server!");
//        System.out.println("receive from ws jws server: " + hello);
    }

}
